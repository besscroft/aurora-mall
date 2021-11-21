package com.besscroft.aurora.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.besscroft.aurora.mall.common.entity.ProductSku;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/10/24 19:43
 */
public interface ProductSkuService extends IService<ProductSku> {

    /**
     * 分页查询商品所有的套餐
     * @param productId 商品id
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页商品列表
     */
    List<ProductSku> getProductSkuPageList(String productId, Integer pageNum, Integer pageSize, String keyword);

}
