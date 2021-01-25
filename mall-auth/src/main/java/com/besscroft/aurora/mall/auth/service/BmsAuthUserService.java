package com.besscroft.aurora.mall.auth.service;

import com.besscroft.aurora.mall.common.entity.BmsAuthResource;
import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

/**
 * 后台用户管理Service
 *
 * @Author Besscroft
 * @Date 2021/1/23 14:53
 */
public interface BmsAuthUserService {

    /**
     * 根据用户名获取后台管理员
     */
    BmsAuthUser getAuthUserByUsername(String username);

    /**
     *
     * @param username
     * @param password
     * @return 登录成功返回jwt的token，失败返回null
     */
    String login(String username,String password);

    /**
     * 获取用户信息
     */
    UserDetails loadUserByUsername(String username);

    /**
     * 获取指定用户的可访问资源
     */
    List<BmsAuthResource> getResourceList(Long adminId);

}
