package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import com.besscroft.aurora.mall.admin.mapper.BmsAuthRoleMapper;
import com.besscroft.aurora.mall.admin.mapper.BmsAuthUserMapper;
import com.besscroft.aurora.mall.admin.service.AuthService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.domain.Oauth2Token;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.BmsAuthRole;
import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Oauth2Token login(String username, String password) {
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
        log.info("响应到了，ajax:{}",accessToken);
        Oauth2Token oauth2Token = (Oauth2Token) accessToken.get("DATA_TAG");
        log.info("DATA_TAG:{}", oauth2Token);
        return oauth2Token;
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

}
