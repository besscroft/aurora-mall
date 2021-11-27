package com.besscroft.aurora.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.besscroft.aurora.mall.admin.domain.param.ProductSkuAddParam;
import com.besscroft.aurora.mall.admin.domain.param.ProductSkuUpdateParam;
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

    /**
     * 根据商品id查询商品套餐
     * @param productSkuId 商品套餐id
     * @return 商品套餐
     */
    ProductSku getProductSkuById(String productSkuId);

    /**
     * 新增商品套餐
     * @param productSkuAddParam 商品套餐参数
     * @return 新增结果
     */
    boolean addProductSku(ProductSkuAddParam productSkuAddParam);

    /**
     * 更新商品套餐
     * @param productSkuUpdateParam 商品套餐参数
     * @return 更新结果
     */
    boolean updateProductSku(ProductSkuUpdateParam productSkuUpdateParam);

    /**
     * 删除商品套餐
     * @param productSkuId 商品套餐id
     * @return 删除结果
     */
    boolean deleteProductSku(String productSkuId);

}
