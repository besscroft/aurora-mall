package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.ProductBrandService;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import com.besscroft.aurora.mall.common.entity.ProductBrand;
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
 * @Author Bess Croft
 * @Date 2021/5/15 14:37
 */
@Slf4j
@Api(tags = "管理系统商品品牌管理接口")
@RestController
@RequestMapping("/productBrand")
public class ProductBrandController {

    @Autowired
    private ProductBrandService productBrandService;

    @WebLog(description = "查询后台管理商品品牌列表")
    @ApiOperation("查询后台管理商品品牌列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        List<ProductBrand> list = productBrandService.getProductBrandPageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @WebLog(description = "获取商品品牌详情")
    @ApiOperation("获取商品品牌详情")
    @ApiImplicitParam(name = "id", value = "品牌id",required = true, dataType = "String")
    @GetMapping("/getProductBrand/{id}")
    public AjaxResult getProductBrand(@PathVariable("id") String id) {
        ProductBrand productBrand = productBrandService.getProductBrandById(id);
        return AjaxResult.success(productBrand);
    }

    @WebLog(description = "新增商品品牌")
    @ApiOperation("新增商品品牌")
    @PostMapping("/addProductBrand")
    public AjaxResult addProductBrand(@RequestBody ProductBrand productBrand) {
        boolean b = productBrandService.addProductBrand(productBrand);
        if (b) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error("哎呀，新增失败了！");
    }

    @WebLog(description = "更新商品品牌")
    @ApiOperation("更新商品品牌")
    @PutMapping("/updateProductBrand")
    public AjaxResult updateProductBrand(@RequestBody ProductBrand productBrand) {
        boolean b = productBrandService.updateProductBrand(productBrand);
        if (b) {
            return AjaxResult.success("更新成功！");
        }
        return AjaxResult.error("哎呀，更新失败了！");
    }

    @WebLog(description = "删除商品品牌")
    @ApiOperation("删除商品品牌")
    @ApiImplicitParam(name = "id", value = "资源id",required = true, dataType = "String")
    @DeleteMapping("/delProductBrand/{id}")
    public AjaxResult delProductBrand(@PathVariable("id") List<String> ids) {
        boolean b = productBrandService.delProductBrand(ids);
        if (b) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("哎呀，删除失败了");
    }

    @WebLog(description = "商品品牌启用状态更新")
    @ApiOperation("商品品牌启用状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "showStatus", value = "显示状态",required = true, dataType = "Boolean"),
            @ApiImplicitParam(name = "id", value = "商品品牌id",required = true, dataType = "Long")
    })
    @PutMapping("/changeSwitch")
    public AjaxResult changeSwitch(@RequestParam boolean showStatus, @RequestParam String id) {
        boolean b = productBrandService.changeSwitch(showStatus, id);
        if (b) {
            return AjaxResult.success("修改成功");
        }
        return AjaxResult.success("修改失败");
    }

}

