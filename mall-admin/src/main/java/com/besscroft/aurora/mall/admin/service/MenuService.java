package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.AuthMenu;

import java.util.List;
import java.util.Map;

/**
 * @Author Besscroft
 * @Date 2021/3/21 19:13
 */
public interface MenuService {

    /**
     * 获取当前用户管理系统菜单动态路由
     * @param adminId 用户id
     * @return
     */
    Map<String, Object> getTreeListById(Long adminId);

    /**
     * 获取当前用户管理系统菜单
     * @param adminId
     * @return
     */
    List<AuthMenu> getMenuListById(Long adminId);

    /**
     * 获取所有系统菜单
     * @return
     */
    List<AuthMenu> getMenuAllList();

    /**
     * 获取所有父菜单
     * @return
     */
    List<AuthMenu> getParentMenu();

    /**
     * 分页查询菜单
     * @return
     */
    List<AuthMenu> getMenuPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取菜单详细信息
     * @param id
     * @return
     */
    AuthMenu getMenuById(Long id);

    /**
     * 更新菜单信息
     * @param authMenu
     * @return
     */
    boolean updateMenu(AuthMenu authMenu);

    /**
     * 修改菜单显示状态
     * @param hidden
     * @param id
     * @param adminId
     * @return
     */
    boolean changeSwitch(boolean hidden, Long id, Long adminId);

    /**
     * 根据id删除菜单
     * @param ids
     * @return
     */
    boolean delMenu(List<Long> ids);

    /**
     * 新增菜单
     * @param authMenu
     * @return
     */
    boolean addMenu(AuthMenu authMenu);

    /**
     * 根据角色id获取菜单树数组
     * @param id
     * @return
     */
    List<Long> getMenuTreeById(Long id);

    /**
     * 获取所有菜单的菜单树
     * @return
     */
    List<AuthMenu> getAllMenuTree();

    /**
     * 批量更新菜单树
     * @param data
     * @param id
     * @return
     */
    boolean updateMenuTree(List<Long> data, Long id);

}
