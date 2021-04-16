package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.MenuService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.entity.BmsAuthMenu;
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

    @ApiOperation("查询后台管理菜单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<BmsAuthMenu> list = menuService.getMenuPageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("获取所有父菜单")
    @GetMapping("/getParentMenu")
    public AjaxResult getParentMenu() {
        List<BmsAuthMenu> list = menuService.getParentMenu();
        return AjaxResult.success(list);
    }

    @ApiOperation("查询菜单详情")
    @ApiImplicitParam(name = "id", value = "菜单id",required = true, dataType = "Long")
    @GetMapping("/getMenu/{id}")
    public AjaxResult getMenu(@PathVariable("id") Long id) {
        BmsAuthMenu menu = menuService.getMenuById(id);
        return AjaxResult.success(menu);
    }

    @ApiOperation("修改菜单")
    @PutMapping("/updateMenu")
    public AjaxResult updateMenu(@Validated @RequestBody BmsAuthMenu bmsAuthMenu) {
        boolean b = menuService.updateMenu(bmsAuthMenu);
        if (b) {
            return AjaxResult.success("更新成功！");
        }
        return AjaxResult.error("更新失败！");
    }

    @ApiOperation("菜单是否显示状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hidden", value = "显示状态",required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "id", value = "菜单id",required = true, dataType = "Long")
    })
    @PutMapping("/changeSwitch")
    public AjaxResult changeSwitch(@RequestParam boolean hidden, @RequestParam Long id) {
        BmsAuthUser currentAdmin = userService.getCurrentAdmin();
        boolean b = menuService.changeSwitch(hidden, id, currentAdmin.getId());
        if (b) {
            return AjaxResult.success("修改成功");
        }
        return AjaxResult.success("修改失败");
    }

    @ApiOperation("删除菜单")
    @ApiImplicitParam(name = "id", value = "菜单id",required = true, dataType = "Long")
    @DeleteMapping("/delMenu/{id}")
    public AjaxResult delMenu(@PathVariable("id") Long id) {
        boolean b = menuService.delMenu(id);
        if (b) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("哎呀，删除失败了！");
    }

    @ApiOperation("新增菜单")
    @PostMapping("/addMenu")
    public AjaxResult addUser(@RequestBody BmsAuthMenu bmsAuthMenu) {
        log.info("bmsAuthMenu:{}", bmsAuthMenu);
        boolean b = menuService.addMenu(bmsAuthMenu);
        if (b) {
            return AjaxResult.success("添加成功！");
        }
        return AjaxResult.error("添加失败！");
    }

    @ApiOperation("根据角色id获取菜单树")
    @ApiImplicitParam(name = "id", value = "角色id", required = true, dataType = "Long")
    @GetMapping("/getMenuTreeById/{id}")
    public AjaxResult getMenuTreeById(@PathVariable("id") Long id) {
        List<Long> tree = menuService.getMenuTreeById(id);
        return AjaxResult.success(tree);
    }

    @ApiOperation("获取所有菜单的菜单树")
    @GetMapping("/getAllMenuTree")
    public AjaxResult getAllMenuTree() {
        List<BmsAuthMenu> tree = menuService.getAllMenuTree();
        return AjaxResult.success(tree);
    }

    @ApiOperation("更新菜单树")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "data", value = "菜单树数据",required = true, dataType = "Long"),
            @ApiImplicitParam(name = "id", value = "菜单id",required = true, dataType = "Long")
    })
    @PutMapping("/updateMenuTree")
    public AjaxResult updateMenuTree(@RequestBody List<Long> data, @RequestParam Long id) {
        boolean b = menuService.updateMenuTree(data, id);
        if (b) {
            return AjaxResult.success("更新成功！");
        }
        return AjaxResult.error("哎呀，更新失败了呢！");
    }

}
