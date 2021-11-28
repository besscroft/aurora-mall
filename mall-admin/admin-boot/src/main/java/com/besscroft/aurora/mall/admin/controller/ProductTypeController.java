package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.ProductTypeService;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import com.besscroft.aurora.mall.common.entity.ProductType;
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
import java.util.Map;

/**
 * @Author Bess Croft
 * @Date 2021/5/10 13:02
 */
@Slf4j
@Api(tags = "管理系统商品类型管理接口")
@RestController
@RequestMapping("/productType")
public class ProductTypeController {

    @Autowired
    private ProductTypeService productTypeService;

    @WebLog(description = "查询后台管理商品类型列表")
    @ApiOperation("查询后台管理商品类型列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize) {
        List<ProductType> list = productTypeService.getProductTypePageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @WebLog(description = "获取商品类型详情")
    @ApiOperation("获取商品类型详情")
    @ApiImplicitParam(name = "id", value = "资源id",required = true, dataType = "Long")
    @GetMapping("/getProductType/{id}")
    public AjaxResult getProductType(@PathVariable("id") String id) {
        ProductType productType = productTypeService.getProductTypeById(id);
        return AjaxResult.success(productType);
    }

    @WebLog(description = "新增商品类型")
    @ApiOperation("新增商品类型")
    @PostMapping("/addProductType")
    public AjaxResult addProductType(@RequestBody ProductType productType) {
        boolean b = productTypeService.addProductType(productType);
        if (b) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error("哎呀，新增失败了！");
    }

    @WebLog(description = "更新商品类型")
    @ApiOperation("更新商品类型")
    @PutMapping("/updateProductType")
    public AjaxResult updateProductType(@RequestBody ProductType productType) {
        boolean b = productTypeService.updateProductType(productType);
        if (b) {
            return AjaxResult.success("更新成功！");
        }
        return AjaxResult.error("哎呀，更新失败了！");
    }

    @WebLog(description = "删除商品类型")
    @ApiOperation("删除商品类型")
    @ApiImplicitParam(name = "id", value = "资源id",required = true, dataType = "Long")
    @DeleteMapping("/delProductType/{id}")
    public AjaxResult delProductType(@PathVariable("id") List<String> ids) {
        boolean b = productTypeService.delProductType(ids);
        if (b) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("哎呀，删除失败了");
    }

    @WebLog(description = "商品类型字典")
    @ApiOperation("商品类型字典接口")
    @GetMapping("/getProductTypeDict")
    public AjaxResult getProductTypeDict() {
        List<Map<String, String>> map = productTypeService.getProductTypeDict();
        return AjaxResult.success(map);
    }

}
