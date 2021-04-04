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
import com.besscroft.aurora.mall.common.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
    @PostMapping("/updateUser")
    public AjaxResult updateUser(@Validated @RequestBody BmsAdminParam bmsAdminParam) {
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
        // 设置登录时间
        userService.setLoginTime(new Date(), currentAdmin.getId());
        return AjaxResult.success(data);
    }

    @ApiOperation("后台管理系统登出功能")
    @PostMapping(value = "/logout")
    public AjaxResult logout() {
        return AjaxResult.success();
    }

    @ApiOperation("查询权限管理模块用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<BmsAuthUser> list = userService.getUserPageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("查询权限管理模块用户详情")
    @ApiImplicitParam(name = "id", value = "用户id",required = true, dataType = "Long")
    @GetMapping("/getUser/{id}")
    public AjaxResult getUser(@PathVariable("id") Long id) {
        BmsAuthUser user = userService.getUserById(id);
        user.setPassword("");
        return AjaxResult.success(user);
    }

    @ApiOperation("修改权限管理模块用户")
    @PutMapping("/updateUser")
    public AjaxResult updateUser(@Validated @RequestBody BmsAuthUser bmsAuthUser) {
        BmsAuthUser currentAdmin = userService.getCurrentAdmin();
        if (!"1".equals(bmsAuthUser.getId()) || ("1".equals(bmsAuthUser.getId()) && "1".equals(currentAdmin.getId()))) {
            boolean b = userService.updateUser(bmsAuthUser);
            if (b) {
                return AjaxResult.success("更新成功！");
            } else {
                return AjaxResult.error("更新失败！");
            }
        }
        return AjaxResult.error("Unauthorized");
    }

    @ApiOperation("用户账户启用状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "启用状态",required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "id", value = "用户id",required = true, dataType = "Long")
    })
    @PutMapping("/changeSwitch")
    public AjaxResult changeSwitch(@RequestParam boolean status, @RequestParam Long id) {
        BmsAuthUser currentAdmin = userService.getCurrentAdmin();
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

    @ApiOperation("删除权限管理模块用户")
    @ApiImplicitParam(name = "id", value = "用户id",required = true, dataType = "Long")
    @DeleteMapping("/delUser/{id}")
    public AjaxResult delUser(@PathVariable("id") Long id) {
        BmsAuthUser currentAdmin = userService.getCurrentAdmin();
        if (!"1".equals(id) || currentAdmin.getId() != id) {
            boolean b = userService.delUser(id);
            if (b) {
                return AjaxResult.success("删除成功！");
            }
        }
        return AjaxResult.error("哎呀，删除失败了！");
    }

    @ApiOperation("新增权限管理模块用户")
    @PostMapping("/addUser")
    public AjaxResult addUser(@RequestBody BmsAuthUser bmsAuthUser) {
        log.info("BmsAuthUser:{}", bmsAuthUser);
        boolean b = userService.addUser(bmsAuthUser);
        if (b) {
            return AjaxResult.success("添加成功！");
        }
        return AjaxResult.error("添加失败！");
    }

}
