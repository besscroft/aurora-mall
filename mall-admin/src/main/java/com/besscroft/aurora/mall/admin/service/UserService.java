package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.dto.BmsAdminParam;
import com.besscroft.aurora.mall.common.domain.Oauth2Token;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;

/**
 * @Author Besscroft
 * @Date 2021/2/17 18:08
 */
public interface UserService {

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    AjaxResult login(String username, String password);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UserDto loadUserByUsername(String username);

    boolean register(BmsAdminParam bmsAdminParam);

}
