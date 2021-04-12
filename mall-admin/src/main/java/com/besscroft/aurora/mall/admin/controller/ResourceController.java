package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.ResourceService;
import com.besscroft.aurora.mall.common.entity.BmsAuthResource;
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
 * @Date 2021/4/10 10:59
 */
@Slf4j
@Api(tags = "管理系统资源接口")
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @ApiOperation("查询后台管理资源列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<BmsAuthResource> list = resourceService.getResourcePageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("获取资源详情")
    @ApiImplicitParam(name = "id", value = "资源id",required = true, dataType = "Long")
    @GetMapping("/getResource/{id}")
    public AjaxResult getResource(@PathVariable("id") Long id) {
        BmsAuthResource resource = resourceService.getResourceById(id);
        return AjaxResult.success(resource);
    }

    @ApiOperation("新增资源")
    @PostMapping("/addResource")
    public AjaxResult addResource(@RequestBody BmsAuthResource bmsAuthResource) {
        boolean b = resourceService.addResource(bmsAuthResource);
        if (b) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error("哎呀，新增失败了！");
    }

    @ApiOperation("更新资源")
    @PutMapping("/updateResource")
    public AjaxResult updateResource(@RequestBody BmsAuthResource bmsAuthResource) {
        boolean b = resourceService.updateResource(bmsAuthResource);
        if (b) {
            return AjaxResult.success("更新成功！");
        }
        return AjaxResult.error("哎呀，更新失败了！");
    }

    @ApiOperation("删除资源")
    @ApiImplicitParam(name = "id", value = "资源id",required = true, dataType = "Long")
    @DeleteMapping("/delResource/{id}")
    public AjaxResult delResource(@PathVariable("id") Long id) {
        boolean b = resourceService.delResource(id);
        if (b) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("哎呀，删除失败了");
    }

}
