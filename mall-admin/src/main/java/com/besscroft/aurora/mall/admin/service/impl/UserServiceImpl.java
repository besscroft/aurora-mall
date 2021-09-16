package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.besscroft.aurora.mall.admin.dto.AdminParam;
import com.besscroft.aurora.mall.admin.mapper.AuthRoleMapper;
import com.besscroft.aurora.mall.admin.mapper.AuthUserMapper;
import com.besscroft.aurora.mall.admin.service.AuthService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.AuthRole;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
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
    private AuthUserMapper authUserMapper;

    @Autowired
    private AuthRoleMapper authRoleMapper;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

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
        log.info("accessToken:{}", accessToken);
        redisTemplate.opsForValue().set(AuthConstants.ADMIN_CLIENT_ID + ":token:user:" + username, accessToken.get("access_token").toString());
        return accessToken;
    }

    @Override
    public boolean logout(Long adminId) {
        AuthUser user = authUserMapper.selectById(adminId);
        redisTemplate.delete(AuthConstants.ADMIN_CLIENT_ID + ":token:user:" + user.getUsername());
        redisTemplate.boundHashOps("admin").delete("user:tree:" + adminId);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean setLoginTime(LocalDate loginTime, Long id) {
        return authUserMapper.updateLoginTime(loginTime, id) > 0;
    }

    @Override
    public UserDto loadUserByUsername(String username) {
        AuthUser authUser = authUserMapper.selectAuthUserByUsername(username);
        if (authUser != null) {
            List<AuthRole> authRoles = authRoleMapper.selectAuthRoleListByAdminId(authUser.getId());
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(authUser,userDto);
            if(CollUtil.isNotEmpty(authRoles)){
                List<String> roleStrList = authRoles.stream().map(item -> item.getId() + "_" + item.getName()).collect(Collectors.toList());
                userDto.setRoles(roleStrList);
            }
            return userDto;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean register(AdminParam adminParam) {
        AuthUser authUser = new AuthUser();
        BeanUtils.copyProperties(adminParam, authUser);
        // 设置用户注册的时间
        authUser.setCreateTime(LocalDate.now());
        // 设置用户状态
        authUser.setStatus(1);
        // 对密码进行加密
        authUser.setPassword(new BCryptPasswordEncoder().encode(adminParam.getPassword()));
        // 更新到数据库
        return authUserMapper.insert(authUser) > 0;
    }

    @Override
    public AuthUser getCurrentAdmin() {
        String header = request.getHeader(AuthConstants.USER_TOKEN_HEADER);
        if(StrUtil.isEmpty(header)){
            log.error("暂未登录或token已经过期");
        }
        UserDto userDto = JSONUtil.toBean(header, UserDto.class);
        return authUserMapper.selectById(userDto.getId());
    }

    @Override
    public List<AuthRole> getRoleList(Long adminId) {
        return authRoleMapper.selectAuthRoleListByAdminId(adminId);
    }

    @Override
    public List<AuthUser> getUserPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<AuthUser> users = authUserMapper.selectUserListByPage(keyword);
        users.forEach(user -> {
            user.setPassword("");
        });
        return users;
    }

    @Override
    public AuthUser getUserById(Long id) {
        return authUserMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateUser(AuthUser authUser) {
        return authUserMapper.updateUser(authUser) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitch(boolean flag, Long id) {
        Integer status = 0;
        if (flag == true) {
            status = 1;
        } else {
            status = 0;
        }
        return authUserMapper.changeSwitch(status, id) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delUser(Long id) {
        return authUserMapper.delUser(id) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addUser(AuthUser authUser) {
        // 设置用户注册的时间
        authUser.setCreateTime(LocalDate.now());
        // 设置用户登录时间与注册时间一致
        authUser.setLoginTime(LocalDate.now());
        // 加密密码
        authUser.setPassword(new BCryptPasswordEncoder().encode(authUser.getPassword()));
        // 设置删除状态
        authUser.setDel(1);
        return authUserMapper.insertUser(authUser) > 0;
    }

    @Override
    public List<AuthUser> getUserAllList() {
        return authUserMapper.getAllList();
    }

}
