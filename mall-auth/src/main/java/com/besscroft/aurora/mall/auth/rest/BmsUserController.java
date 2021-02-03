package com.besscroft.aurora.mall.auth.rest;

import com.besscroft.aurora.mall.auth.service.BmsAuthUserService;
import com.besscroft.aurora.mall.common.dto.BmsUserLoginParam;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Besscroft
 * @Date 2021/1/23 13:55
 */
@Api(tags = "后台管理系统用户登录接口")
@RestController
@RequestMapping("/bms/auth/")
public class BmsUserController {

    @Autowired
    private BmsAuthUserService bmsAuthUserService;

    @ApiOperation(value = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public AjaxResult login(@Validated BmsUserLoginParam bmsUserLoginParam) {
        System.out.println("请求进来了：" + bmsUserLoginParam.toString());
        String token = bmsAuthUserService.login(bmsUserLoginParam.getUsername(), bmsUserLoginParam.getPassword());
        if (StringUtils.isNotEmpty(token)) {
            return AjaxResult.success("登录成功",token);
        }
        return AjaxResult.error();
    }

}
