package com.besscroft.aurora.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.besscroft.aurora.mall.admin.domain.param.AdminParam;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.AuthRole;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * 后台管理用户服务
 *
 * @Author Bess Croft
 * @Date 2021/2/17 18:08
 */
public interface UserService extends IService<AuthUser> {

    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return AjaxResult
     */
    AjaxResult login(String username, String password);

    /**
     * 系统用户退出登录处理
     * @param adminId 用户id
     * @return
     */
    boolean logout(Long adminId);

    /**
     * 登录成功后设置登录时间
     * @param loginTime 登录时间
     * @param id 用户id
     * @return
     */
    boolean setLoginTime(LocalDateTime loginTime, Long id);

    /**
     * 获取用户信息
     * @param username 用户名
     * @return 登录用户信息
     */
    UserDto loadUserByUsername(String username);

    /**
     * 添加后台管理系统的用户
     * @param adminParam 后台管理系统用户参数实体
     * @return
     */
    boolean register(AdminParam adminParam);

    /**
     * 获取当前登录后台用户
     * @return 用户实体
     */
    AuthUser getCurrentAdmin();

    /**
     * 获取用户对应的角色列表
     * @param adminId 用户id
     * @return 用户的角色列表
     */
    List<AuthRole> getRoleList(Long adminId);

    /**
     * 获取认证后的用户信息
     * @return
     */
    Map<String, Object> getUserInfo();

    /**
     * 分页查询用户
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页用户集合
     */
    List<AuthUser> getUserPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @return 用户实体
     */
    AuthUser getUserById(Long id);

    /**
     * 更新用户信息
     * @param authUser 用户实体
     * @return
     */
    boolean updateUser(AuthUser authUser);

    /**
     * 用户账户启用状态更新
     * @param flag 启用状态
     * @param id 用户id
     * @return
     */
    boolean changeSwitch(boolean flag, Long id);

    /**
     * 删除权限管理模块用户
     * @param id 用户id
     * @return
     */
    boolean delUser(Long id);

    /**
     * 新增权限管理模块用户
     * @param authUser 用户实体
     * @return
     */
    boolean addUser(AuthUser authUser);

    /**
     * 查询所有用户
     * @return 所有用户集合
     */
    List<AuthUser> getUserAllList();

    /**
     * 导出选定用户数据方法
     * @param ids 用户id
     * @param response
     */
    void export(List<Long> ids, HttpServletResponse response);

}
