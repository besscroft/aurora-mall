package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.AuthRole;
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

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:53
 */
@SpringBootTest
public class RoleServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceTest.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getRolePageList() throws JsonProcessingException {
        List<AuthRole> rolePageList = roleService.getRolePageList(1, 10, "");
        assertNotNull(rolePageList, "获取角色列表失败！");
        LOGGER.info("角色列表:{}", objectMapper.writeValueAsString(rolePageList));
    }

    @Test
    void getRoleById() throws JsonProcessingException {
        Long roleId = 1L;
        AuthRole role = roleService.getRoleById(roleId);
        assertNotNull(role, "获取角色详情失败！");
        LOGGER.info("角色详情:{}", objectMapper.writeValueAsString(role));
    }

    @Test
    void addRole() {
        AuthRole role = AuthRole.builder()
                .name("单元测试角色")
                .description("单元测试专用")
                .createTime(LocalDateTime.now())
                .status(0)
                .sort(10L)
                .del(1).build();
        boolean b = roleService.addRole(role);
        assertTrue(b, "新增角色失败！");
    }

    @Test
    void updateRole() {
        AuthRole role = AuthRole.builder()
                .id(100L)
                .name("单元测试角色")
                .description("单元测试专用")
                .createTime(LocalDateTime.now())
                .status(0)
                .sort(10L)
                .del(1).build();
        boolean b = roleService.updateRole(role);
        assertTrue(b, "角色更新失败！");
    }

    @Test
    void delRoleById() {
        List<Long> ids = Collections.singletonList(100L);
        boolean b = roleService.delRoleById(ids);
        assertTrue(b, "删除失败！");
    }

    @Test
    void changeSwitch() {
        boolean status = true;
        Long roleId = 2L;
        boolean b = roleService.changeSwitch(status, roleId);
        assertTrue(b, "角色可用状态更新失败！");
    }

    @Test
    void getRoleAll() throws JsonProcessingException {
        List<AuthRole> authRoles = roleService.getRoleAll();
        assertNotNull(authRoles, "获取所有角色信息失败！");
        LOGGER.info("所有角色信息:{}", objectMapper.writeValueAsString(authRoles));
    }

    @Test
    void updateRoleById() {
        Long userId = 100L;
        Long roleId = 100L;
        boolean b = roleService.updateRoleById(userId, roleId);
        assertTrue(b, "用户和角色对应关系更新失败！");
    }

}
