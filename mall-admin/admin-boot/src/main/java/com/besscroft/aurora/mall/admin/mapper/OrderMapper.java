package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/11/28 15:40
 */
public interface OrderMapper extends BaseMapper<Order> {

    List<Order> selectOrderList(@Param("keyword") String keyword);

}
