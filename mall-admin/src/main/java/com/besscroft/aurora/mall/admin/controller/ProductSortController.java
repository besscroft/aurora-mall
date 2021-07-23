package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.ProductSortService;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.entity.ProductSort;
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
 * @Date 2021/5/7 14:26
 */
@Slf4j
@Api(tags = "管理系统商品分类接口")
@RestController
@RequestMapping("/productSort")
public class ProductSortController {

    @Autowired
    private ProductSortService productSortService;

    @WebLog(description = "查询后台管理商品分类列表")
    @ApiOperation("查询后台管理商品分类列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<ProductSort> list = productSortService.getProductSortPageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @WebLog(description = "获取商品分类详情")
    @ApiOperation("获取商品分类详情")
    @ApiImplicitParam(name = "id", value = "资源id",required = true, dataType = "Long")
    @GetMapping("/getProductSort/{id}")
    public AjaxResult getProductSort(@PathVariable("id") Long id) {
        ProductSort productSort = productSortService.getProductSortById(id);
        return AjaxResult.success(productSort);
    }

    @WebLog(description = "新增商品分类")
    @ApiOperation("新增商品分类")
    @PostMapping("/addProductSort")
    public AjaxResult addProductSort(@RequestBody ProductSort productSort) {
        boolean b = productSortService.addProductSort(productSort);
        if (b) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error("哎呀，新增失败了！");
    }

    @WebLog(description = "更新商品分类")
    @ApiOperation("更新商品分类")
    @PutMapping("/updateProductSort")
    public AjaxResult updateProductSort(@RequestBody ProductSort productSort) {
        boolean b = productSortService.updateProductSort(productSort);
        if (b) {
            return AjaxResult.success("更新成功！");
        }
        return AjaxResult.error("哎呀，更新失败了！");
    }

    @WebLog(description = "删除商品分类")
    @ApiOperation("删除商品分类")
    @ApiImplicitParam(name = "id", value = "资源id",required = true, dataType = "Long")
    @DeleteMapping("/delProductSort/{id}")
    public AjaxResult delProductSort(@PathVariable("id") List<Long> ids) {
        boolean b = productSortService.delProductSort(ids);
        if (b) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("哎呀，删除失败了");
    }

    @WebLog(description = "查询商品分类所有父级")
    @ApiOperation("查询商品分类所有父级")
    @GetMapping("/getProductSortByParent")
    public AjaxResult getProductSortByParent() {
        List<ProductSort> list = productSortService.getProductSortByParent();
        return AjaxResult.success(list);
    }

    @WebLog(description = "商品分类启用状态更新")
    @ApiOperation("商品分类启用状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "showStatus", value = "显示状态",required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "id", value = "商品分类id",required = true, dataType = "Long")
    })
    @PutMapping("/changeSwitch")
    public AjaxResult changeSwitch(@RequestParam boolean showStatus, @RequestParam Long id) {
        boolean b = productSortService.changeSwitch(showStatus, id);
        if (b) {
            return AjaxResult.success("修改成功");
        }
        return AjaxResult.success("修改失败");
    }

}
