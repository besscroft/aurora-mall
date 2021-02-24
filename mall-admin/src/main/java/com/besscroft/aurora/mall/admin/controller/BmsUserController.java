package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.dto.BmsAdminParam;
import com.besscroft.aurora.mall.admin.dto.BmsUserLoginParam;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.domain.Oauth2Token;
import com.besscroft.aurora.mall.common.domain.UserDto;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author Besscroft
 * @Date 2021/2/17 18:01
 */
@Slf4j
@Api(tags = "管理系统用户接口")
@RestController
@RequestMapping("/user")
public class BmsUserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录并返回token")
    @PostMapping(value = "/login")
    public AjaxResult login(@Validated @RequestBody BmsUserLoginParam bmsUserLoginParam) {
        log.info("请求进来了,打印bmsUserLoginParam:{}",bmsUserLoginParam);
        AjaxResult login = userService.login(bmsUserLoginParam.getUsername(), bmsUserLoginParam.getPassword());
        log.info("请求进来了,AjaxResult:{}",login);
        return login;
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

}
