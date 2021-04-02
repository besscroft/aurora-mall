package com.besscroft.aurora.mall.admin.controller;

import cn.hutool.core.collection.CollUtil;
import com.besscroft.aurora.mall.admin.dto.BmsAdminParam;
import com.besscroft.aurora.mall.admin.dto.BmsUserLoginParam;
import com.besscroft.aurora.mall.admin.service.MenuService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.BmsAuthRole;
import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Besscroft
 * @Date 2021/2/17 18:01
 */
@Slf4j
@Api(tags = "管理系统用户接口")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "登录并返回token")
    @PostMapping(value = "/login")
    public AjaxResult login(@Validated @RequestBody BmsUserLoginParam bmsUserLoginParam) {
        log.info("请求进来了,打印bmsUserLoginParam:{}",bmsUserLoginParam);
        AjaxResult result = userService.login(bmsUserLoginParam.getUsername(), bmsUserLoginParam.getPassword());
        log.info("请求进来了,oauth2Token:{}",result);
        return AjaxResult.success(result);
    }

    @ApiOperation("根据用户名获取用户信息")
    @GetMapping(value = "/loadByUsername")
    public UserDto loadByUsername(@RequestParam String username) {
        UserDto userDto = userService.loadUserByUsername(username);
        return userDto;
    }

    @ApiOperation(value = "超级管理员添加后台管理系统用户接口")
    @PostMapping("/register")
    public AjaxResult register(@Validated @RequestBody BmsAdminParam bmsAdminParam) {
        boolean b = userService.register(bmsAdminParam);
        if (b) {
            return AjaxResult.success("添加管理平台用户成功!");
        } else {
            return AjaxResult.error("添加管理平台用户失败!");
        }
    }

    @ApiOperation(value = "获取当前后台系统登录用户的一些信息")
    @GetMapping("/info")
    public AjaxResult getInfo() {
        BmsAuthUser currentAdmin = userService.getCurrentAdmin();
        Map<String, Object> data = menuService.getTreeListById(currentAdmin.getId());
        data.put("username", currentAdmin.getNickName());
        data.put("icon", currentAdmin.getIcon());
        List<BmsAuthRole> roleList = userService.getRoleList(currentAdmin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(BmsAuthRole::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        return AjaxResult.success(data);
    }

    @ApiOperation("后台管理系统登出功能")
    @PostMapping(value = "/logout")
    public AjaxResult logout() {
        return AjaxResult.success();
    }

}
