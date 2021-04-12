package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.BmsAuthRole;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/10 9:42
 */
public interface RoleService {

    /**
     * 分页查询角色列表
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    List<BmsAuthRole> getRolePageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id查询角色详情
     * @param id
     * @return
     */
    BmsAuthRole getRoleById(Long id);

    /**
     * 新增角色
     * @param bmsAuthRole
     * @return
     */
    boolean addRole(BmsAuthRole bmsAuthRole);

    /**
     * 更新角色信息
     * @param bmsAuthRole
     * @return
     */
    boolean updateRole(BmsAuthRole bmsAuthRole);

    /**
     * 根据角色id进行假删除
     * @param id
     * @return
     */
    boolean delRoleById(Long id);

    /**
     * 角色是否可用状态更新
     * @param status
     * @param id
     * @return
     */
    boolean changeSwitch(boolean status, Long id);

}
