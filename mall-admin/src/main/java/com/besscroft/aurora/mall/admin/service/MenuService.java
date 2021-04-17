package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.BmsAuthMenu;

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
    List<BmsAuthMenu> getMenuListById(Long adminId);

    /**
     * 获取所有系统菜单
     * @return
     */
    List<BmsAuthMenu> getMenuAllList();

    /**
     * 获取所有父菜单
     * @return
     */
    List<BmsAuthMenu> getParentMenu();

    /**
     * 分页查询菜单
     * @return
     */
    List<BmsAuthMenu> getMenuPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取菜单详细信息
     * @param id
     * @return
     */
    BmsAuthMenu getMenuById(Long id);

    /**
     * 更新菜单信息
     * @param bmsAuthMenu
     * @return
     */
    boolean updateMenu(BmsAuthMenu bmsAuthMenu);

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
     * @param id
     * @return
     */
    boolean delMenu(Long id);

    /**
     * 新增菜单
     * @param bmsAuthMenu
     * @return
     */
    boolean addMenu(BmsAuthMenu bmsAuthMenu);

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
    List<BmsAuthMenu> getAllMenuTree();

    /**
     * 批量更新菜单树
     * @param data
     * @param id
     * @return
     */
    boolean updateMenuTree(List<Long> data, Long id);

}
