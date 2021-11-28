package com.besscroft.aurora.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.besscroft.aurora.mall.common.entity.Order;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/11/28 15:39
 */
public interface OrderService extends IService<Order> {

    /**
     * 查询所有订单
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 搜索关键字
     * @return 订单信息
     */
    List<Order> getOrderPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 获取订单详情
     * @param orderId 订单id
     * @return 订单详情
     */
    Order getOrderDetail(String orderId);

    /**
     * 删除订单
     * @param orderId 订单id
     * @return 是否删除成功
     */
    boolean deleteOrder(String orderId);

}
