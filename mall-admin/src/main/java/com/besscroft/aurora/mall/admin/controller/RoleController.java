package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.RoleService;
import com.besscroft.aurora.mall.common.entity.BmsAuthRole;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.common.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/10 9:42
 */
@Slf4j
@Api(tags = "管理系统角色接口")
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @ApiOperation("查询后台管理角色列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<BmsAuthRole> list = roleService.getRolePageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("查询角色详情")
    @ApiImplicitParam(name = "id", value = "角色id",required = true, dataType = "Long")
    @GetMapping("/getRole/{id}")
    public AjaxResult getRole(@PathVariable("id") Long id) {
        BmsAuthRole role = roleService.getRoleById(id);
        return AjaxResult.success(role);
    }

    @ApiOperation("新增角色")
    @PostMapping("/addRole")
    public AjaxResult addRole(@RequestBody BmsAuthRole bmsAuthRole) {
        boolean b = roleService.addRole(bmsAuthRole);
        if (b) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error("哎呀，新增失败了！");
    }

    @ApiOperation("修改角色")
    @PutMapping("/updateRole")
    public AjaxResult updateRole(@RequestBody BmsAuthRole bmsAuthRole) {
        boolean b = roleService.updateRole(bmsAuthRole);
        if (b) {
            return AjaxResult.success("更新成功！");
        }
        return AjaxResult.error("哎呀，更新失败了！");
    }

    @ApiOperation("删除角色")
    @ApiImplicitParam(name = "id", value = "角色id",required = true, dataType = "Long")
    @DeleteMapping("/delRole/{id}")
    public AjaxResult delRole(@PathVariable("id") Long id) {
        boolean b = roleService.delRoleById(id);
        if (b) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("哎呀，删除失败了！");
    }

    @ApiOperation("角色是否可用状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "status", value = "可用状态",required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "id", value = "角色id",required = true, dataType = "Long")
    })
    @PutMapping("/changeSwitch")
    public AjaxResult changeSwitch(@RequestParam boolean status, @RequestParam Long id) {
        boolean b = roleService.changeSwitch(status, id);
        if (b) {
            return AjaxResult.success("状态更新成功！");
        }
        return AjaxResult.error("哎呀，状态更新失败了！");
    }

}