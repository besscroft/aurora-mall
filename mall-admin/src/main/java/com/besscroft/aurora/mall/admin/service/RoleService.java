package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.AuthRole;

import java.util.List;

/**
 * 后台管理角色服务
 *
 * @Author Bess Croft
 * @Date 2021/4/10 9:42
 */
public interface RoleService {

    /**
     * 分页查询角色列表
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页角色列表
     */
    List<AuthRole> getRolePageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id查询角色详情
     * @param id 角色id
     * @return 角色实体
     */
    AuthRole getRoleById(Long id);

    /**
     * 新增角色
     * @param authRole 角色实体
     * @return
     */
    boolean addRole(AuthRole authRole);

    /**
     * 更新角色信息
     * @param authRole 角色实体
     * @return
     */
    boolean updateRole(AuthRole authRole);

    /**
     * 根据角色id进行假删除
     * @param ids 角色id集合
     * @return
     */
    boolean delRoleById(List<Long> ids);

    /**
     * 角色是否可用状态更新
     * @param status 可以状态
     * @param id 角色id
     * @return
     */
    boolean changeSwitch(boolean status, Long id);

    /**
     * 查询所有角色
     * @return 所有角色集合
     */
    List<AuthRole> getRoleAll();

    /**
     * 根据用户id和角色id修改用户和角色的对应关系
     * @param userId 用户id
     * @param roleId 角色id
     * @return
     */
    boolean updateRoleById(Long userId, Long roleId);

}
