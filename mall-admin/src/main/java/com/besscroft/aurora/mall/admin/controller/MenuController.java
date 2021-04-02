package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.MenuService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.entity.BmsAuthMenu;
import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/3/21 19:06
 */
@Slf4j
@Api(tags = "管理系统菜单接口")
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private UserService userService;

    @Autowired
    private MenuService menuService;

    @ApiOperation(value = "获取当前用户管理系统菜单")
    @GetMapping(value = "/getMenu")
    public AjaxResult getRouter() {
        BmsAuthUser currentAdmin = userService.getCurrentAdmin();
        List<BmsAuthMenu> list = menuService.getMenuListById(currentAdmin.getId());
        log.info("菜单：{}",list);
        return AjaxResult.success(list);
    }

}
