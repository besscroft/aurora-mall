package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.dto.AdminParam;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.AuthRole;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;

import java.util.Date;
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
     * 系统用户退出登录处理
     * @param adminId
     * @return
     */
    boolean logout(Long adminId);

    /**
     * 登录成功后设置登录时间
     * @param loginTime
     * @return
     */
    boolean setLoginTime(Date loginTime, Long id);

    /**
     * 获取用户信息
     * @param username
     * @return
     */
    UserDto loadUserByUsername(String username);

    /**
     * 添加后台管理系统的用户
     * @param adminParam
     * @return
     */
    boolean register(AdminParam adminParam);

    /**
     * 获取当前登录后台用户
     * @return
     */
    AuthUser getCurrentAdmin();

    /**
     * 获取用户对应的角色列表
     * @param adminId
     * @return
     */
    List<AuthRole> getRoleList(Long adminId);

    /**
     * 分页查询用户
     * @return
     */
    List<AuthUser> getUserPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取用户信息
     * @param id
     * @return
     */
    AuthUser getUserById(Long id);

    /**
     * 更新用户信息
     * @param authUser
     * @return
     */
    boolean updateUser(AuthUser authUser);

    /**
     * 用户账户启用状态更新
     * @param flag
     * @param id
     * @return
     */
    boolean changeSwitch(boolean flag, Long id);

    /**
     * 删除权限管理模块用户
     * @param id
     * @return
     */
    boolean delUser(Long id);

    /**
     * 新增权限管理模块用户
     * @param authUser
     * @return
     */
    boolean addUser(AuthUser authUser);

    /**
     * 查询所有用户
     * @return
     */
    List<AuthUser> getUserAllList();

}
