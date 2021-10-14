package com.besscroft.aurora.mall.admin.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.besscroft.aurora.mall.admin.dto.AdminParam;
import com.besscroft.aurora.mall.admin.dto.UserLoginParam;
import com.besscroft.aurora.mall.admin.service.MenuService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.entity.AuthRole;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.common.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Bess Croft
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

    @WebLog(description = "登录接口")
    @ApiOperation(value = "登录并返回token")
    @PostMapping(value = "/login")
    public AjaxResult login(@Validated @RequestBody UserLoginParam userLoginParam) {
        log.info("请求进来了,打印UserLoginParam:{}", userLoginParam);
        AjaxResult result = userService.login(userLoginParam.getUsername(), userLoginParam.getPassword());
        log.info("请求进来了,oauth2Token:{}",result);
        return AjaxResult.success(result);
    }

    @WebLog(description = "根据用户名获取用户信息接口")
    @ApiOperation("根据用户名获取用户信息")
    @GetMapping(value = "/loadByUsername")
    public UserDto loadByUsername(@RequestParam String username) {
        UserDto userDto = userService.loadUserByUsername(username);
        return userDto;
    }

    @WebLog(description = "超级管理员添加后台管理系统用户接口")
    @ApiOperation(value = "超级管理员添加后台管理系统用户接口")
    @PostMapping("/updateUser")
    public AjaxResult updateUser(@Validated @RequestBody AdminParam adminParam) {
        boolean b = userService.register(adminParam);
        if (b) {
            return AjaxResult.success("添加管理平台用户成功!");
        } else {
            return AjaxResult.error("添加管理平台用户失败!");
        }
    }

    @WebLog(description = "获取当前后台系统登录用户的一些信息")
    @ApiOperation(value = "获取当前后台系统登录用户的一些信息")
    @GetMapping("/info")
    public AjaxResult getInfo() {
        AuthUser currentAdmin = userService.getCurrentAdmin();
        Map<String, Object> data = menuService.getTreeListById(currentAdmin.getId());
        data.put("username", currentAdmin.getNickName());
        data.put("icon", currentAdmin.getIcon());
        List<AuthRole> roleList = userService.getRoleList(currentAdmin.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(AuthRole::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        // 设置登录时间
        userService.setLoginTime(LocalDateTime.now(), currentAdmin.getId());
        return AjaxResult.success(data);
    }

    @WebLog(description = "后台管理系统登出功能")
    @ApiOperation("后台管理系统登出功能")
    @PostMapping(value = "/logout")
    public AjaxResult logout() {
        AuthUser currentAdmin = userService.getCurrentAdmin();
        if (ObjectUtil.isNotNull(currentAdmin)) {
            userService.logout(currentAdmin.getId());
        }
        return AjaxResult.success("成功退出登录啦！");
    }

    @WebLog(description = "查询权限管理模块用户列表")
    @ApiOperation("查询权限管理模块用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<AuthUser> list = userService.getUserPageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @WebLog(description = "查询权限管理模块用户详情")
    @ApiOperation("查询权限管理模块用户详情")
    @ApiImplicitParam(name = "id", value = "用户id",required = true, dataType = "Long")
    @GetMapping("/getUser/{id}")
    public AjaxResult getUser(@PathVariable("id") Long id) {
        AuthUser user = userService.getUserById(id);
        user.setPassword("");
        return AjaxResult.success(user);
    }

    @WebLog(description = "修改权限管理模块用户")
    @ApiOperation("修改权限管理模块用户")
    @PutMapping("/updateUser")
    public AjaxResult updateUser(@Validated @RequestBody AuthUser authUser) {
        AuthUser currentAdmin = userService.getCurrentAdmin();
        if (!"1".equals(authUser.getId()) || ("1".equals(authUser.getId()) && "1".equals(currentAdmin.getId()))) {
            boolean b = userService.updateUser(authUser);
            if (b) {
                return AjaxResult.success("更新成功！");
            } else {
                return AjaxResult.error("更新失败！");
            }
        }
        return AjaxResult.error("Unauthorized");
    }

    @WebLog(description = "用户账户启用状态更新")
    @ApiOperation("用户账户启用状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "启用状态",required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "id", value = "用户id",required = true, dataType = "Long")
    })
    @PutMapping("/changeSwitch")
    public AjaxResult changeSwitch(@RequestParam boolean status, @RequestParam Long id) {
        AuthUser currentAdmin = userService.getCurrentAdmin();
        if (currentAdmin.getId() != id && !"1".equals(id)) {
            boolean b = userService.changeSwitch(status, id);
            if (b && status == true) {
                return AjaxResult.success("启用成功");
            } else if (b && status == false) {
                return AjaxResult.success("禁用成功");
            }
        }
        return AjaxResult.error("哎呀，更新失败了！");
    }

    @WebLog(description = "删除权限管理模块用户")
    @ApiOperation("删除权限管理模块用户")
    @ApiImplicitParam(name = "id", value = "用户id",required = true, dataType = "Long")
    @DeleteMapping("/delUser/{id}")
    public AjaxResult delUser(@PathVariable("id") Long id) {
        AuthUser currentAdmin = userService.getCurrentAdmin();
        if (!"1".equals(id) || currentAdmin.getId() != id) {
            boolean b = userService.delUser(id);
            if (b) {
                return AjaxResult.success("删除成功！");
            }
        }
        return AjaxResult.error("哎呀，删除失败了！");
    }

    @WebLog(description = "新增权限管理模块用户")
    @ApiOperation("新增权限管理模块用户")
    @PostMapping("/addUser")
    public AjaxResult addUser(@RequestBody AuthUser authUser) {
        boolean b = userService.addUser(authUser);
        if (b) {
            return AjaxResult.success("添加成功！");
        }
        return AjaxResult.error("添加失败！");
    }

    @ApiOperation("导出权限管理模块用户")
    @PostMapping("/exportUser")
    public void export(@RequestBody List<Long> data, HttpServletResponse response) {
        userService.export(data, response);
    }

}
