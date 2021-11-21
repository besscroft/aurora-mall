package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.ProductSkuService;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import com.besscroft.aurora.mall.common.entity.ProductSku;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.common.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/10/24 19:38
 */
@Api(tags = "管理系统商品套餐管理接口")
@RestController
@RequestMapping("/productSku")
public class ProductSkuController {

    @Autowired
    private ProductSkuService productSkuService;

    @WebLog(description = "查询商品对应的理商品套餐列表")
    @ApiOperation("查询商品对应的理商品套餐列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "productId", value = "商品id", required = true, dataType = "String")
    })
    @RequestMapping("/list")
    public AjaxResult list(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestParam("productId") String productId) {
        List<ProductSku> list = productSkuService.getProductSkuPageList(productId, pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

}
