package com.besscroft.aurora.mall.admin.controller;

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
@RequestMapping("/bms/user")
public class BmsUserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录并返回token")
    @PostMapping(value = "/login")
    public AjaxResult login(@Validated @RequestBody BmsUserLoginParam bmsUserLoginParam) {
        log.info("请求进来了,打印:{}",bmsUserLoginParam);
        Oauth2Token token = userService.login(bmsUserLoginParam.getUsername(), bmsUserLoginParam.getPassword());
        log.info("请求进来了,打印:{}",token);
        return AjaxResult.success(token);
    }

    @ApiOperation("根据用户名获取用户信息")
    @GetMapping(value = "/loadByUsername")
    public UserDto loadByUsername(@RequestParam String username) {
        UserDto userDto = userService.loadUserByUsername(username);
        return userDto;
    }

}
