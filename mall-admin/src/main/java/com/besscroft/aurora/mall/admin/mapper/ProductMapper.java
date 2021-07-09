package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.Product;

import java.util.List;

/**
 * 后台管理商品持久化
 *
 * @Author Besscroft
 * @Date 2021/5/15 19:27
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 根据条件查询所有商品
     * @param keyword 关键字
     * @return 分页商品列表
     */
    List<Product> selectProductListByPage(String keyword);

}
