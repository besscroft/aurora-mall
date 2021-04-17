package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.ResourceSortService;
import com.besscroft.aurora.mall.common.entity.BmsAuthResourceSort;
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
 * @Date 2021/4/17 19:03
 */
@Slf4j
@Api(tags = "管理系统资源类别接口")
@RestController
@RequestMapping("/resourceSort")
public class ResourceSortController {

    @Autowired
    private ResourceSortService resourceSortService;

    @ApiOperation("查询后台管理资源列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<BmsAuthResourceSort> list = resourceSortService.getResourcePageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @ApiOperation("获取资源详情")
    @ApiImplicitParam(name = "id", value = "资源id",required = true, dataType = "Long")
    @GetMapping("/getResourceSort/{id}")
    public AjaxResult getResource(@PathVariable("id") Long id) {
        BmsAuthResourceSort resourceSort = resourceSortService.getResourceSortById(id);
        return AjaxResult.success(resourceSort);
    }

    @ApiOperation("新增资源")
    @PostMapping("/addResourceSort")
    public AjaxResult addResource(@RequestBody BmsAuthResourceSort bmsAuthResourceSort) {
        boolean b = resourceSortService.addResourceSort(bmsAuthResourceSort);
        if (b) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error("哎呀，新增失败了！");
    }

    @ApiOperation("更新资源")
    @PutMapping("/updateResourceSort")
    public AjaxResult updateResource(@RequestBody BmsAuthResourceSort bmsAuthResourceSort) {
        boolean b = resourceSortService.updateResourceSort(bmsAuthResourceSort);
        if (b) {
            return AjaxResult.success("更新成功！");
        }
        return AjaxResult.error("哎呀，更新失败了！");
    }

    @ApiOperation("删除资源")
    @ApiImplicitParam(name = "id", value = "资源id",required = true, dataType = "Long")
    @DeleteMapping("/delResourceSort/{id}")
    public AjaxResult delResource(@PathVariable("id") Long id) {
        boolean b = resourceSortService.delResourceSort(id);
        if (b) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("哎呀，删除失败了");
    }

}
