package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.ProductBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/15 14:43
 */
public interface ProductBrandMapper extends BaseMapper<ProductBrand> {

    /**
     * 分页查询商品品牌
     * @param keyword
     * @return
     */
    List<ProductBrand> selectProductBrandListByPage(String keyword);

    /**
     * 新增商品品牌
     * @param productBrand
     * @return
     */
    int addProductBrand(ProductBrand productBrand);

    /**
     * 更新商品品牌
     * @param productBrand
     * @return
     */
    int updateProductBrand(ProductBrand productBrand);

    /**
     * 修改商品品牌显示状态
     * @param showStatus
     * @param id
     * @return
     */
    int changeSwitch(@Param("showStatus") Integer showStatus,
                     @Param("id") Long id);

}
