package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.ProductType;

import java.util.List;

/**
 * 后台管理商品类型服务
 *
 * @Author Besscroft
 * @Date 2021/5/10 14:16
 */
public interface ProductTypeService {

    /**
     * 分页查询商品类型列表
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页商品类型列表
     */
    List<ProductType> getProductTypePageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取商品类型详情
     * @param id 商品类型id
     * @return 商品类型实体
     */
    ProductType getProductTypeById(Long id);

    /**
     * 新增商品类型
     * @param productType 商品类型实体
     * @return
     */
    boolean addProductType(ProductType productType);

    /**
     * 修改商品类型
     * @param productType 商品类型实体
     * @return
     */
    boolean updateProductType(ProductType productType);

    /**
     * 删除商品类型
     * @param ids 商品类型id集合
     * @return
     */
    boolean delProductType(List<Long> ids);

}
