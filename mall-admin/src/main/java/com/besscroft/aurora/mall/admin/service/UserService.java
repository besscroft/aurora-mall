package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.dto.BmsAdminParam;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.BmsAuthRole;
import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;

import java.util.List;

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

    /**
     * 添加后台管理系统的用户
     * @param bmsAdminParam
     * @return
     */
    boolean register(BmsAdminParam bmsAdminParam);

    /**
     * 获取当前登录后台用户
     * @return
     */
    BmsAuthUser getCurrentAdmin();

    /**
     * 获取用户对应的角色列表
     * @param adminId
     * @return
     */
    List<BmsAuthRole> getRoleList(Long adminId);

}
