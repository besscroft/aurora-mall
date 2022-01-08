package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.AuthMenu;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:57
 */
@SpringBootTest
public class MenuServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceTest.class);

    @Autowired
    private MenuService menuService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getTreeListById() throws JsonProcessingException {
        Long adminId = 1L;
        Map<String, Object> list = menuService.getTreeListById(adminId);
        assertNotNull(list, "获取当前用户管理系统菜单动态路由失败！");
        LOGGER.info("当前用户管理系统菜单动态路由:{}", objectMapper.writeValueAsString(list));
    }

    @Test
    void getMenuListById() throws JsonProcessingException {
        Long adminId = 1L;
        List<AuthMenu> authMenuList = menuService.getMenuListById(adminId);
        assertNotNull(authMenuList, "获取当前用户菜单失败！");
        LOGGER.info("当前用户的菜单:{}", objectMapper.writeValueAsString(authMenuList));
    }

    @Test
    void getMenuAllList() throws JsonProcessingException {
        List<AuthMenu> menuAllList = menuService.getMenuAllList();
        assertNotNull(menuAllList, "获取系统所有菜单失败！");
        LOGGER.info("所有系统菜单:{}", objectMapper.writeValueAsString(menuAllList));
    }

    @Test
    void getParentMenu() throws JsonProcessingException {
        List<AuthMenu> parentMenu = menuService.getParentMenu();
        assertNotNull(parentMenu, "获取所有父菜单失败！");
        LOGGER.info("所有父菜单:{}", objectMapper.writeValueAsString(parentMenu));
    }

    @Test
    void getMenuPageList() throws JsonProcessingException {
        List<AuthMenu> menuPageList = menuService.getMenuPageList(1, 10, "");
        assertNotNull(menuPageList, "获取分页菜单失败！");
        LOGGER.info("分页菜单:{}", objectMapper.writeValueAsString(menuPageList));
    }

    @Test
    void getMenuById() throws JsonProcessingException {
        Long menuId = 1L;
        AuthMenu authMenu = menuService.getMenuById(menuId);
        assertNotNull(authMenu, "获取菜单失败！");
        LOGGER.info("菜单:{}", objectMapper.writeValueAsString(authMenu));
    }

    @Test
    void updateMenu() {
        AuthMenu authMenu = AuthMenu.builder()
                .name("测试菜单")
                .level(1)
                .parentId(1L)
                .parentTitle("测试父菜单")
                .sort(10)
                .title("测试菜单")
                .createTime(LocalDateTime.now())
                .hidden(0)
                .component("").build();
        boolean b = menuService.updateMenu(authMenu);
        assertNotNull(b, "更新菜单失败！");
    }

    @Test
    void changeSwitch() {
        boolean hidden = true;
        Long menuId = 1L;
        Long adminId = 1L;
        boolean b = menuService.changeSwitch(hidden, menuId, adminId);
        assertNotNull(b, "更新菜单显示状态失败！");
    }

    @Test
    void delMenu() {
        List<Long> ids = Collections.singletonList(1000L);
        boolean b = menuService.delMenu(ids);
        assertNotNull(b, "删除菜单失败！");
    }

    @Test
    void addMenu() {
        AuthMenu authMenu = AuthMenu.builder()
                .id(1000L)
                .name("测试菜单")
                .level(1)
                .parentId(1L)
                .parentTitle("测试父菜单")
                .sort(10)
                .title("测试菜单")
                .createTime(LocalDateTime.now())
                .hidden(0)
                .component("").build();
        boolean b = menuService.addMenu(authMenu);
        assertNotNull(b, "新增菜单失败！");
    }

    @Test
    void getMenuTreeById() throws JsonProcessingException {
        Long roleId = 1L;
        List<Long> list = menuService.getMenuTreeById(roleId);
        assertNotNull(list, "获取当前用户菜单树数组失败！");
        LOGGER.info("当前用户菜单树数组:{}", objectMapper.writeValueAsString(list));
    }

    @Test
    void getAllMenuTree() throws JsonProcessingException {
        List<AuthMenu> list = menuService.getAllMenuTree();
        assertNotNull(list, "获取所有菜单树数组失败！");
        LOGGER.info("所有菜单树数组:{}", objectMapper.writeValueAsString(list));
    }

    @Test
    void updateMenuTree() {
        List<Long> ids = Collections.singletonList(1000L);
        Long roleId = 2L;
        boolean b = menuService.updateMenuTree(ids, roleId);
        assertNotNull(b, "更新菜单树失败！");
    }

}
