package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.ProductBrand;

import java.util.List;

/**
 * 后台管理商品品牌服务
 *
 * @Author Bess Croft
 * @Date 2021/5/15 14:40
 */
public interface ProductBrandService {

    /**
     * 分页查询商品品牌列表
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页商品品牌列表
     */
    List<ProductBrand> getProductBrandPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取商品品牌详情
     * @param id 商品品牌id
     * @return 商品品牌详情
     */
    ProductBrand getProductBrandById(Long id);

    /**
     * 新增商品品牌
     * @param productBrand 商品品牌实体
     * @return
     */
    boolean addProductBrand(ProductBrand productBrand);

    /**
     * 修改商品品牌
     * @param productBrand 商品品牌实体
     * @return
     */
    boolean updateProductBrand(ProductBrand productBrand);

    /**
     * 删除商品品牌
     * @param ids 商品品牌id集合
     * @return
     */
    boolean delProductBrand(List<Long> ids);

    /**
     * 修改商品品牌显示状态
     * @param showStatus 显示状态
     * @param id 商品品牌id
     * @return
     */
    boolean changeSwitch(boolean showStatus, Long id);

}
