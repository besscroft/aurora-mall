package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.ProductType;

import java.util.List;

/**
 * 后台管理商品类型持久化
 *
 * @Author Bess Croft
 * @Date 2021/5/10 15:54
 */
public interface ProductTypeMapper extends BaseMapper<ProductType> {

    /**
     * 分页查询商品类型
     * @param keyword 关键字
     * @return 分页商品类型列表
     */
    List<ProductType> selectProductTypeListByPage(String keyword);

    /**
     * 新增商品类型
     * @param productType 商品类型实体
     * @return
     */
    int addProductType(ProductType productType);

    /**
     * 更新商品类型
     * @param productType 商品类型实体
     * @return
     */
    int updateProductType(ProductType productType);

}
