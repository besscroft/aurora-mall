package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.ProductSort;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/7 14:29
 */
public interface ProductSortService {

    /**
     * 分页查询商品分类列表
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    List<ProductSort> getProductSortPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取商品分类详情
     * @param id
     * @return
     */
    ProductSort getProductSortById(Long id);

    /**
     * 新增商品分类
     * @param productSort
     * @return
     */
    boolean addProductSort(ProductSort productSort);

    /**
     * 修改商品分类
     * @param productSort
     * @return
     */
    boolean updateProductSort(ProductSort productSort);

    /**
     * 删除商品分类
     * @param id
     * @return
     */
    boolean delProductSort(Long id);

    /**
     * 查询商品分类所有父级
     * @return
     */
    List<ProductSort> getProductSortByParent();

    /**
     * 修改商品分类显示状态
     * @param showStatus
     * @param id
     * @return
     */
    boolean changeSwitch(boolean showStatus, Long id);

}
