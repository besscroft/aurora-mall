package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.AuthMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/3/21 19:17
 */
public interface AuthMenuMapper extends BaseMapper<AuthMenu> {

    /**
     * 获取当前用户的管理系统菜单
     * @param adminId
     * @return
     */
    List<AuthMenu> getListById(Long adminId);

    /**
     * 获取当前用户的父菜单
     * @param adminId
     * @return
     */
    List<AuthMenu> getParentListById(Long adminId);

    /**
     * 获取所有父菜单
     * @return
     */
    List<AuthMenu> getParentMenu();

    /**
     * 根据父菜单id获取当前用户的子菜单
     * @param adminId
     * @param parentId
     * @return
     */
    List<AuthMenu> getChildListById(@Param("adminId") Long adminId,
                                    @Param("parentId") Long parentId);

    /**
     * 根据父菜单id获取所有的子菜单
     * @param parentId
     * @return
     */
    List<AuthMenu> getChildList(Long parentId);

    /**
     * 分页查询菜单
     * @param keyword
     * @return
     */
    List<AuthMenu> selectMenuListByPage(String keyword);

    /**
     * 根据id获取菜单详细信息
     * @param id
     * @return
     */
    AuthMenu selectMenuById(Long id);

    /**
     * 更新菜单
     * @param authMenu
     * @return
     */
    int updateMenu(AuthMenu authMenu);

    /**
     * 修改菜单显示状态
     * @param hidden
     * @param id
     * @return
     */
    int changeSwitch(@Param("hidden") Integer hidden,
                    @Param("id") Long id);

    /**
     * 根据id删除菜单
     * @param id
     * @return
     */
    int delMenu(Long id);

    /**
     * 添加菜单
     * @param authMenu
     * @return
     */
    int addMenu(AuthMenu authMenu);

    /**
     * 根据角色id查询已绑定的菜单数组
     * @param id
     * @return
     */
    List<Long> selectMenuTreeById(Long id);

    /**
     * 根据角色id删除角色菜单关系
     * @param id
     * @return
     */
    int deleteRoleMenuRelation(Long id);

    int insertRoleMenuRelation(@Param("menuId") Long menuId,
                               @Param("roleId") Long roleId);

}
