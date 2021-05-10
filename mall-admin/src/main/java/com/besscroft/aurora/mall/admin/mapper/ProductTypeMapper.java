package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.ProductType;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/10 15:54
 */
public interface ProductTypeMapper extends BaseMapper<ProductType> {

    /**
     * 分页查询商品类型
     * @param keyword
     * @return
     */
    List<ProductType> selectProductTypeListByPage(String keyword);

    /**
     * 新增商品类型
     * @param productType
     * @return
     */
    int addProductType(ProductType productType);

    /**
     * 更新商品类型
     * @param productType
     * @return
     */
    int updateProductType(ProductType productType);

}
