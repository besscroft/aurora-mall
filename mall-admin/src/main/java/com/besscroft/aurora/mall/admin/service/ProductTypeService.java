package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.ProductType;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/10 14:16
 */
public interface ProductTypeService {

    /**
     * 分页查询商品类型列表
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    List<ProductType> getProductTypePageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取商品类型详情
     * @param id
     * @return
     */
    ProductType getProductTypeById(Long id);

    /**
     * 新增商品类型
     * @param productType
     * @return
     */
    boolean addProductType(ProductType productType);

    /**
     * 修改商品类型
     * @param productType
     * @return
     */
    boolean updateProductType(ProductType productType);

    /**
     * 删除商品类型
     * @param id
     * @return
     */
    boolean delProductType(Long id);

}
