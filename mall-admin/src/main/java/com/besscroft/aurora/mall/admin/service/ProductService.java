package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.Product;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/15 19:25
 */
public interface ProductService {

    /**
     * 分页查询所有商品
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    List<Product> getProductPageList(Integer pageNum, Integer pageSize, String keyword);

}
