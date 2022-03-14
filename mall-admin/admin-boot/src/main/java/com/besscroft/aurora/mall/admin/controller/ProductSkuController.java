package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.domain.param.ProductSkuAddParam;
import com.besscroft.aurora.mall.admin.domain.param.ProductSkuUpdateParam;
import com.besscroft.aurora.mall.admin.service.ProductSkuService;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import com.besscroft.aurora.mall.common.entity.ProductSku;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.common.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/10/24 19:38
 */
@Api(tags = "管理系统商品套餐管理接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/productSku")
public class ProductSkuController {

    private final ProductSkuService productSkuService;

    @WebLog(description = "查询商品对应的理商品套餐列表")
    @ApiOperation("查询商品对应的理商品套餐列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "productId", value = "商品id", required = true, dataType = "String")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize,
                           @RequestParam("productId") String productId) {
        List<ProductSku> list = productSkuService.getProductSkuPageList(productId, pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @WebLog(description = "商品套餐查询接口")
    @ApiOperation("商品套餐查询接口")
    @ApiImplicitParam(name = "skuId", value = "套餐id", required = true, dataType = "String")
    @GetMapping("/getProductSkuById/{skuId}")
    public AjaxResult getProductSkuById(@PathVariable("skuId") String skuId) {
        ProductSku productSku = productSkuService.getProductSkuById(skuId);
        return AjaxResult.success(productSku);
    }

    @WebLog(description = "新增套餐")
    @ApiOperation("新增套餐接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "套餐对应的商品id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "price", value = "套餐价格", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "stock", value = "库存", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "lowStock", value = "预警库存", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "pic", value = "展示图片", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lockStock", value = "锁定库存", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "spData", value = "商品销售属性", required = true, dataType = "String")
    })
    @PostMapping("/addSku")
    public AjaxResult addSku(@RequestBody @Valid ProductSkuAddParam productSkuAddParam) {
        boolean b = productSkuService.addProductSku(productSkuAddParam);
        if (b) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error("哎呀，添加失败了！");
    }

    @WebLog(description = "更新套餐")
    @ApiOperation("更新套餐接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "productId", value = "套餐对应的商品id", required = true, dataType = "String"),
            @ApiImplicitParam(name = "price", value = "套餐价格", required = true, dataType = "BigDecimal"),
            @ApiImplicitParam(name = "stock", value = "库存", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "lowStock", value = "预警库存", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "pic", value = "展示图片", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lockStock", value = "锁定库存", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "spData", value = "商品销售属性", required = true, dataType = "String")
    })
    @PutMapping("/updateSku")
    public AjaxResult updateSku(@RequestBody @Valid ProductSkuUpdateParam productSkuUpdateParam) {
        boolean b = productSkuService.updateProductSku(productSkuUpdateParam);
        if (b) {
            return AjaxResult.success("更新成功！");
        }
        return AjaxResult.error("哎呀，更新失败了！");
    }

    @WebLog(description = "删除套餐")
    @ApiOperation("删除套餐接口")
    @ApiImplicitParam(name = "skuId", value = "套餐id", required = true, dataType = "String")
    @DeleteMapping("/productSkuDel/{skuId}")
    public AjaxResult productSkuDel(@PathVariable("skuId") String skuId) {
        boolean b = productSkuService.deleteProductSku(skuId);
        if (b) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("哎呀，删除失败了！");
    }

}
