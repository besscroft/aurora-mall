package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.ProductSort;

import java.util.List;

/**
 * 后台管理商品分类服务
 *
 * @Author Besscroft
 * @Date 2021/5/7 14:29
 */
public interface ProductSortService {

    /**
     * 分页查询商品分类列表
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页商品分类列表
     */
    List<ProductSort> getProductSortPageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取商品分类详情
     * @param id 商品分类id
     * @return 商品分类实体
     */
    ProductSort getProductSortById(Long id);

    /**
     * 新增商品分类
     * @param productSort 商品分类实体
     * @return
     */
    boolean addProductSort(ProductSort productSort);

    /**
     * 修改商品分类
     * @param productSort 商品分类实体
     * @return
     */
    boolean updateProductSort(ProductSort productSort);

    /**
     * 删除商品分类
     * @param ids 商品分类id
     * @return
     */
    boolean delProductSort(List<Long> ids);

    /**
     * 查询商品分类所有父级
     * @return 商品分类父级实体集合
     */
    List<ProductSort> getProductSortByParent();

    /**
     * 修改商品分类显示状态
     * @param showStatus 显示状态
     * @param id 商品分类id
     * @return
     */
    boolean changeSwitch(boolean showStatus, Long id);

}
