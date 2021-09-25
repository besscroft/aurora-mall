package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.AuthMenu;

import java.util.List;
import java.util.Map;

/**
 * 后台管理菜单服务
 *
 * @Author Bess Croft
 * @Date 2021/3/21 19:13
 */
public interface MenuService {

    /**
     * 获取当前用户管理系统菜单动态路由
     * @param adminId 用户id
     * @return 当前用户的所有动态路由
     */
    Map<String, Object> getTreeListById(Long adminId);

    /**
     * 获取当前用户管理系统菜单
     * @param adminId 用户id
     * @return 当前用户的菜单
     */
    List<AuthMenu> getMenuListById(Long adminId);

    /**
     * 获取所有系统菜单
     * @return 所有菜单
     */
    List<AuthMenu> getMenuAllList();

    /**
     * 获取所有父菜单
     * @return 所有父菜单
     */
    List<AuthMenu> getParentMenu();

    /**
     * 分页查询菜单
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页菜单
     */
    List<AuthMenu> getMenuPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取菜单详细信息
     * @param id 菜单id
     * @return 菜单详细信息
     */
    AuthMenu getMenuById(Long id);

    /**
     * 更新菜单信息
     * @param authMenu 菜单实体
     * @return
     */
    boolean updateMenu(AuthMenu authMenu);

    /**
     * 修改菜单显示状态
     * @param hidden 显示状态
     * @param id 菜单id
     * @param adminId 用户id
     * @return
     */
    boolean changeSwitch(boolean hidden, Long id, Long adminId);

    /**
     * 根据id删除菜单
     * @param ids id集合
     * @return
     */
    boolean delMenu(List<Long> ids);

    /**
     * 新增菜单
     * @param authMenu 菜单实体
     * @return
     */
    boolean addMenu(AuthMenu authMenu);

    /**
     * 根据角色id获取菜单树数组
     * @param id 菜单id
     * @return 菜单树数组
     */
    List<Long> getMenuTreeById(Long id);

    /**
     * 获取所有菜单的菜单树
     * @return 所有菜单的菜单树
     */
    List<AuthMenu> getAllMenuTree();

    /**
     * 批量更新菜单树
     * @param menuIds 菜单id集合
     * @param id 角色id
     * @return
     */
    boolean updateMenuTree(List<Long> menuIds, Long id);

}
