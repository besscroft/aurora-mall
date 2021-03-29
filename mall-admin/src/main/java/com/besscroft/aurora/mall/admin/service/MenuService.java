package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.BmsAuthMenu;

import java.util.List;

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
    List<BmsAuthMenu> getTreeListById(Long adminId);

}
