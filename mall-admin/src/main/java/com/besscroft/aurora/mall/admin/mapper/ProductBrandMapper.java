package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.ProductBrand;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台管理商品品牌持久化
 *
 * @Author Bess Croft
 * @Date 2021/5/15 14:43
 */
public interface ProductBrandMapper extends BaseMapper<ProductBrand> {

    /**
     * 分页查询商品品牌
     * @param keyword 关键字
     * @return 分页商品品牌列表
     */
    List<ProductBrand> selectProductBrandListByPage(String keyword);

    /**
     * 新增商品品牌
     * @param productBrand 商品品牌实体
     * @return
     */
    int addProductBrand(ProductBrand productBrand);

    /**
     * 更新商品品牌
     * @param productBrand 商品品牌实体
     * @return
     */
    int updateProductBrand(ProductBrand productBrand);

    /**
     * 修改商品品牌显示状态
     * @param showStatus 显示状态
     * @param id 商品品牌id
     * @return
     */
    int changeSwitch(@Param("showStatus") Integer showStatus,
                     @Param("id") Long id);

}
