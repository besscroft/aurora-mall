package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.AuthMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台管理菜单持久化
 *
 * @Author Bess Croft
 * @Date 2021/3/21 19:17
 */
public interface AuthMenuMapper extends BaseMapper<AuthMenu> {

    /**
     * 获取当前用户的管理系统菜单
     * @param adminId 用户id
     * @return 用户的系统菜单集合
     */
    List<AuthMenu> getListById(@Param("adminId") Long adminId);

    /**
     * 获取当前用户的父菜单
     * @param adminId 用户id
     * @return 用户的父菜单集合
     */
    List<AuthMenu> getParentListById(@Param("adminId") Long adminId);

    /**
     * 获取所有父菜单
     * @return 所有父菜单集合
     */
    List<AuthMenu> getParentMenu();

    /**
     * 根据父菜单id获取当前用户的子菜单
     * @param adminId 用户id
     * @param parentId 父菜单id
     * @return 用户的子菜单集合
     */
    List<AuthMenu> getChildListById(@Param("adminId") Long adminId,
                                    @Param("parentId") Long parentId);

    /**
     * 根据父菜单id获取所有的子菜单
     * @param parentId 父菜单id
     * @return 父菜单对应的子菜单集合
     */
    List<AuthMenu> getChildList(@Param("parentId") Long parentId);

    /**
     * 分页查询菜单
     * @param keyword 关键字
     * @return 分页菜单集合
     */
    List<AuthMenu> selectMenuListByPage(@Param("keyword") String keyword);

    /**
     * 根据id获取菜单详细信息
     * @param id 菜单id
     * @return 菜单实体
     */
    AuthMenu selectMenuById(@Param("id") Long id);

    /**
     * 更新菜单
     * @param authMenu 菜单实体
     * @return
     */
    int updateMenu(AuthMenu authMenu);

    /**
     * 修改菜单显示状态
     * @param hidden 显示状态
     * @param id 菜单id
     * @return
     */
    int changeSwitch(@Param("hidden") Integer hidden,
                     @Param("id") Long id);

    /**
     * 添加菜单
     * @param authMenu 菜单实体
     * @return
     */
    int addMenu(AuthMenu authMenu);

    /**
     * 根据角色id查询已绑定的菜单数组
     * @param id 角色id
     * @return 角色的菜单数组
     */
    List<Long> selectMenuTreeById(@Param("id") Long id);

    /**
     * 根据角色id删除角色菜单关系
     * @param id 角色id
     * @return
     */
    int deleteRoleMenuRelation(@Param("id") Long id);

    /**
     * 插入角色和菜单对应关系
     * @param menuIds 菜单id集合
     * @param roleId 角色id
     * @return
     */
    int insertRoleMenuRelation(@Param("menuIds") List<Long> menuIds,
                               @Param("roleId") Long roleId);

}
