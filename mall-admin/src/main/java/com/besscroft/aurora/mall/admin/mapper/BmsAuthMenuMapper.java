package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.BmsAuthMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/3/21 19:17
 */
public interface BmsAuthMenuMapper extends BaseMapper<BmsAuthMenu> {

    /**
     * 获取当前用户的管理系统菜单
     * @param adminId
     * @return
     */
    List<BmsAuthMenu> getListById(Long adminId);

    /**
     * 获取当前用户的父菜单
     * @param adminId
     * @return
     */
    List<BmsAuthMenu> getParentListById(Long adminId);

    /**
     * 获取所有父菜单
     * @return
     */
    List<BmsAuthMenu> getParentMenu();

    /**
     * 根据父菜单id获取当前用户的子菜单
     * @param adminId
     * @param parentId
     * @return
     */
    List<BmsAuthMenu> getChildListById(@Param("adminId") Long adminId,
                                       @Param("parentId") Long parentId);

    /**
     * 分页查询菜单
     * @param keyword
     * @return
     */
    List<BmsAuthMenu> selectMenuListByPage(String keyword);

    /**
     * 根据id获取菜单详细信息
     * @param id
     * @return
     */
    BmsAuthMenu selectMenuById(Long id);

    /**
     * 更新菜单
     * @param bmsAuthMenu
     * @return
     */
    int updateMenu(BmsAuthMenu bmsAuthMenu);

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
     * @param bmsAuthMenu
     * @return
     */
    int addMenu(BmsAuthMenu bmsAuthMenu);

}
