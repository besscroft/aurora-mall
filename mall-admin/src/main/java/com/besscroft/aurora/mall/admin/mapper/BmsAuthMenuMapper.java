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
     * 根据父菜单id获取当前用户的子菜单
     * @param adminId
     * @param parentId
     * @return
     */
    List<BmsAuthMenu> getChildListById(@Param("adminId") Long adminId,
                                       @Param("parentId") Long parentId);

}
