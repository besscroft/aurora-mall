package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.ProductBrand;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/15 14:40
 */
public interface ProductBrandService {

    /**
     * 分页查询商品品牌列表
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    List<ProductBrand> getProductBrandPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取商品品牌详情
     * @param id
     * @return
     */
    ProductBrand getProductBrandById(Long id);

    /**
     * 新增商品品牌
     * @param productBrand
     * @return
     */
    boolean addProductBrand(ProductBrand productBrand);

    /**
     * 修改商品品牌
     * @param productBrand
     * @return
     */
    boolean updateProductBrand(ProductBrand productBrand);

    /**
     * 删除商品品牌
     * @param ids
     * @return
     */
    boolean delProductBrand(List<Long> ids);

    /**
     * 修改商品品牌显示状态
     * @param showStatus
     * @param id
     * @return
     */
    boolean changeSwitch(boolean showStatus, Long id);

}
