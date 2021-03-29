package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.besscroft.aurora.mall.admin.dto.BmsAdminParam;
import com.besscroft.aurora.mall.admin.mapper.BmsAuthRoleMapper;
import com.besscroft.aurora.mall.admin.mapper.BmsAuthUserMapper;
import com.besscroft.aurora.mall.admin.service.AuthService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.BmsAuthRole;
import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Besscroft
 * @Date 2021/2/17 18:08
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private AuthService authService;

    @Autowired
    private BmsAuthUserMapper bmsAuthUserMapper;

    @Autowired
    private BmsAuthRoleMapper bmsAuthRoleMapper;

    @Autowired
    private HttpServletRequest request;

    @Override
    public AjaxResult login(String username, String password) {
        if(StrUtil.isEmpty(username)||StrUtil.isEmpty(password)){
            log.error("用户名或密码不能为空！");
        }
        Map<String, String> params = new HashMap<>();
        params.put("client_id", AuthConstants.ADMIN_CLIENT_ID);
        params.put("client_secret","123456");
        params.put("grant_type","password");
        params.put("username",username);
        params.put("password",password);
        AjaxResult accessToken = authService.getAccessToken(params);
        log.info("accessToken:{}",accessToken);
        return accessToken;
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        BmsAuthUser bmsAuthUser = bmsAuthUserMapper.selectBmsAuthUserByUsername(username);
        if (bmsAuthUser != null) {
            List<BmsAuthRole> bmsAuthRoles = bmsAuthRoleMapper.selectBmsAuthRoleListByAdminId(bmsAuthUser.getId());
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(bmsAuthUser,userDto);
            if(CollUtil.isNotEmpty(bmsAuthRoles)){
                List<String> roleStrList = bmsAuthRoles.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDto.setRoles(roleStrList);
            }
            return userDto;
        }
        return null;
    }

    @Override
    @Transactional
    public boolean register(BmsAdminParam bmsAdminParam) {
        BmsAuthUser bmsAuthUser = new BmsAuthUser();
        BeanUtils.copyProperties(bmsAdminParam, bmsAuthUser);
        // 设置用户注册的时间
        bmsAuthUser.setCreateTime(new Date());
        // 设置用户状态
        bmsAuthUser.setStatus(1);
        // 对密码进行加密
        bmsAuthUser.setPassword(new BCryptPasswordEncoder().encode(bmsAdminParam.getPassword()));
        // 更新到数据库
        int insert = bmsAuthUserMapper.insert(bmsAuthUser);
        return insert > 0;
    }

    @Override
    public BmsAuthUser getCurrentAdmin() {
        String header = request.getHeader(AuthConstants.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(header)){
            log.error("暂未登录或token已经过期");
        }
        UserDto userDto = JSONUtil.toBean(header, UserDto.class);
        BmsAuthUser bmsAuthUser = bmsAuthUserMapper.selectById(userDto.getId());
        return bmsAuthUser;
    }

    @Override
    public List<BmsAuthRole> getRoleList(Long adminId) {
        return bmsAuthRoleMapper.selectBmsAuthRoleListByAdminId(adminId);
    }

}
