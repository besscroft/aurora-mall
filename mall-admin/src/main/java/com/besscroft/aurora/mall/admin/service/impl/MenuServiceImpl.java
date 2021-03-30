package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.BmsAuthMenuMapper;
import com.besscroft.aurora.mall.admin.service.MenuService;
import com.besscroft.aurora.mall.common.entity.BmsAuthMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/3/21 19:15
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private BmsAuthMenuMapper bmsAuthMenuMapper;

    @Override
    public List<BmsAuthMenu> getTreeListById(Long adminId) {
        List<BmsAuthMenu> menuList = bmsAuthMenuMapper.getParentListById(adminId);
        menuList.forEach(menu -> {
            List<BmsAuthMenu> childListById = bmsAuthMenuMapper.getChildListById(adminId, menu.getId());
            menu.setChildren(childListById);
        });
        return menuList;
    }

}
