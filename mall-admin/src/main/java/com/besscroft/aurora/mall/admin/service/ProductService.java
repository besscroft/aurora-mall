package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.Product;

import java.util.List;

/**
 * 后台管理商品服务
 *
 * @Author Besscroft
 * @Date 2021/5/15 19:25
 */
public interface ProductService {

    /**
     * 分页查询所有商品
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页商品列表
     */
    List<Product> getProductPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 新增商品
     * @param product 商品参数(新增）
     * @return
     */
    boolean productAdd(Product product);

}
