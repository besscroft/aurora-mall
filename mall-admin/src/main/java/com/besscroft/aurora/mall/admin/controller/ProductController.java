package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.ProductService;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.entity.Product;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.common.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author Bess Croft
 * @Date 2021/5/15 19:23
 */
@Slf4j
@Api(tags = "管理系统商品分类接口")
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @WebLog(description = "查询后台管理商品列表")
    @ApiOperation("查询后台管理商品列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult list(@RequestParam("pageNum") Integer pageNum,
                           @RequestParam("pageSize") Integer pageSize) {
        List<Product> list = productService.getProductPageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @WebLog(description = "新增商品")
    @ApiOperation("新增商品")
    @PostMapping("/productAdd")
    public AjaxResult productAdd(@RequestBody Product product) {
        boolean b = productService.productAdd(product);
        if (b) {
            return AjaxResult.success("新增成功！");
        }
        return AjaxResult.error("哎呀，添加失败了！");
    }

    /**
     * 商品删除接口
     * @param id 商品id
     * @return
     */
    @WebLog(description = "删除商品")
    @ApiOperation("删除商品")
    @DeleteMapping("/productDel/{id}")
    public AjaxResult productDel(@PathVariable("id") String id) {
        boolean b = productService.productDel(id);
        if (b) {
            return AjaxResult.success("删除成功！");
        }
        return AjaxResult.error("哎呀，删除失败了！");
    }

    @ApiOperation("导出商品信息")
    @PostMapping("/exportProduct")
    public void export(@RequestBody List<String> data, HttpServletResponse response) {
        productService.export(data, response);
    }

    @WebLog(description = "上架状态更新")
    @ApiOperation("上架状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hidden", value = "上架状态",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "id", value = "商品id",required = true, dataType = "String")
    })
    @PutMapping("/changeSwitchPush")
    public AjaxResult changeSwitchPush(@RequestParam("hidden") Integer hidden,
                                       @RequestParam("id") String id) {
        boolean b = productService.changeSwitchPush(hidden, id);
        if (b) {
            return AjaxResult.success("修改成功");
        }
        return AjaxResult.success("修改失败");
    }

    @WebLog(description = "新品状态更新")
    @ApiOperation("新品状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hidden", value = "新品状态",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "id", value = "商品id",required = true, dataType = "String")
    })
    @PutMapping("/changeSwitchNew")
    public AjaxResult changeSwitchNew(@RequestParam("hidden") Integer hidden,
                                      @RequestParam("id") String id) {
        boolean b = productService.changeSwitchNew(hidden, id);
        if (b) {
            return AjaxResult.success("修改成功");
        }
        return AjaxResult.success("修改失败");
    }

    @WebLog(description = "推荐状态更新")
    @ApiOperation("推荐状态更新")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "hidden", value = "推荐状态",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "id", value = "商品id",required = true, dataType = "String")
    })
    @PutMapping("/changeSwitchRecommend")
    public AjaxResult changeSwitchRecommend(@RequestParam("hidden") Integer hidden,
                                            @RequestParam("id") String id) {
        boolean b = productService.changeSwitchRecommend(hidden, id);
        if (b) {
            return AjaxResult.success("修改成功");
        }
        return AjaxResult.success("修改失败");
    }

}
