package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.domain.dto.UserInfoDetailDto;
import com.besscroft.aurora.mall.admin.service.MallUserService;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import com.besscroft.aurora.mall.common.entity.UserInfo;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.common.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/12/7 21:20
 */
@Api(tags = "商城用户管理接口")
@RestController
@RequestMapping("/mall/user")
public class MallUserController {

    @Autowired
    private MallUserService mallUserService;

    @WebLog(description = "获取用户信息列表")
    @ApiOperation("获取用户信息列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult getUserList(@RequestParam("pageNum") Integer pageNum,
                              @RequestParam("pageSize") Integer pageSize) {
        List<UserInfo> list = mallUserService.getUserList(pageNum, pageSize);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @WebLog(description = "用户详情信息")
    @ApiOperation("用户详情信息")
    @ApiImplicitParam(name = "id", value = "用户id",required = true, dataType = "String")
    @GetMapping("/detail")
    public AjaxResult getInfo(@RequestParam("id") String id) {
        UserInfoDetailDto userDetail = mallUserService.getUserDetail(id);
        return AjaxResult.success(userDetail);
    }

}
