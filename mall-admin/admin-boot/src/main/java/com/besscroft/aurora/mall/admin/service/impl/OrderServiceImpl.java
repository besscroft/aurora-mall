package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.OrderMapper;
import com.besscroft.aurora.mall.admin.service.OrderService;
import com.besscroft.aurora.mall.common.entity.Order;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/11/28 15:40
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Override
    public List<Order> getOrderPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectOrderList(keyword);
    }

    @Override
    public Order getOrderDetail(String orderId) {
        return this.baseMapper.selectById(orderId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteOrder(String orderId) {
        return this.baseMapper.deleteById(orderId) > 0;
    }

}
