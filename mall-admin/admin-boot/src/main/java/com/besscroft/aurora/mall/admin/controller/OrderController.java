package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.OrderService;
import com.besscroft.aurora.mall.common.annotation.WebLog;
import com.besscroft.aurora.mall.common.entity.Order;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.common.util.CommonPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/11/28 15:38
 */
@Api(tags = "订单管理")
@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @WebLog(description = "获取订单列表")
    @ApiOperation("获取订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer")
    })
    @GetMapping("/list")
    public AjaxResult getOrderList(@RequestParam("pageNum") Integer pageNum,
                                   @RequestParam("pageSize") Integer pageSize) {
        List<Order> list = orderService.getOrderPageList(pageNum, pageSize, null);
        return AjaxResult.success(CommonPage.restPage(list));
    }

    @WebLog(description = "订单详情")
    @ApiOperation("订单详情")
    @ApiImplicitParam(name = "orderId", value = "订单id",required = true, dataType = "String")
    @GetMapping("/detail/{orderId}")
    public AjaxResult getOrderDetail(@PathVariable("orderId") String orderId) {
        Order detail = orderService.getOrderDetail(orderId);
        return AjaxResult.success(detail);
    }

    @WebLog(description = "删除订单")
    @ApiOperation("删除订单")
    @ApiImplicitParam(name = "orderId", value = "订单id",required = true, dataType = "String")
    @DeleteMapping("/delete/{orderId}")
    public AjaxResult delOrder(@PathVariable("orderId") String orderId) {
        boolean b = orderService.deleteOrder(orderId);
        if (b) {
            return AjaxResult.success("删除成功");
        }
        return AjaxResult.error("删除失败");
    }

}
