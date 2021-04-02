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

}
