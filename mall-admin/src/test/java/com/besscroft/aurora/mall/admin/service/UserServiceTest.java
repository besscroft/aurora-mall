package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.dto.AdminParam;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.AuthRole;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 16:16
 */
@SpringBootTest
public class UserServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void login() throws Exception {
        String username = "admin";
        String password = "666666";
        AjaxResult result = userService.login(username, password);
        LOGGER.info("result:{}", objectMapper.writeValueAsString(result));
    }

    @Test
    public void logout() throws Exception {
        Long adminId = 1L;
        boolean b = userService.logout(adminId);
        assertTrue(b, "退出登录操作失败！");
    }

    @Test
    public void setLoginTime() throws Exception {
        Long adminId = 1L;
        boolean b = userService.setLoginTime(LocalDateTime.now(), adminId);
        assertTrue(b, "登录成功后设置登录时间操作失败！");
    }

    @Test
    public void loadUserByUsername() throws Exception {
        String username = "admin";
        UserDto dto = userService.loadUserByUsername(username);
        LOGGER.info("当前用户的信息:{}", objectMapper.writeValueAsString(dto));
    }

    @Test
    public void register() throws Exception {
        AdminParam param = new AdminParam();
        param.setUsername("test001");
        param.setPassword("666666");
        param.setNickName("测试1号");
        boolean b = userService.register(param);
        assertTrue(b, "添加管理系统新用户失败！");
    }

    @Test
    public void getCurrentAdmin() throws Exception {
        AuthUser currentAdmin = userService.getCurrentAdmin();
        assertNotNull(currentAdmin, "获取当前用户失败！");
    }

    @Test
    public void getRoleList() throws Exception {
        Long adminId = 1L;
        List<AuthRole> roleList = userService.getRoleList(adminId);
        LOGGER.info("用户对应的角色列表:{}", objectMapper.writeValueAsString(roleList));
    }

    @Test
    public void getUserPageList() throws Exception {
        List<AuthUser> userPageList = userService.getUserPageList(1, 10, "");
        LOGGER.info("用户列表:{}", objectMapper.writeValueAsString(userPageList));
    }

    @Test
    public void getUserById() throws Exception {
        Long adminId = 1L;
        AuthUser user = userService.getUserById(adminId);
        LOGGER.info("用户详细信息:{}", objectMapper.writeValueAsString(user));
    }

    @Test
    public void updateUser() throws Exception {
        AuthUser user = new AuthUser();
        user.setId(3L);
        user.setNickName("测试");
        boolean b = userService.updateUser(user);
        assertTrue(b, "更新用户信息失败！");
    }

    @Test
    public void changeSwitch() throws Exception {
        Long adminId = 1L;
        boolean b = userService.changeSwitch(true, adminId);
        assertTrue(b, "更新账号启用状态失败！");
    }

    @Test
    public void delUser() throws Exception {
        Long adminId = 10L;
        boolean b = userService.delUser(adminId);
        assertTrue(b, "删除用户失败，可能该用户不存在！");
    }

    @Test
    public void addUser() throws Exception {
        AuthUser user = new AuthUser();
        user.setUsername("test666");
        user.setPassword("666666");
        boolean b = userService.addUser(user);
        assertTrue(b, "添加用户失败！");
    }

    @Test
    public void getUserAllList() throws Exception {
        List<AuthUser> userAllList = userService.getUserAllList();
        LOGGER.info("所有用户:{}", objectMapper.writeValueAsString(userAllList));
    }

}
