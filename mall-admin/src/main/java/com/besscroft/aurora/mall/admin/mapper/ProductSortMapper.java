package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.ProductSort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/7 14:39
 */
public interface ProductSortMapper extends BaseMapper<ProductSort> {

    /**
     * 分页查询商品分类
     * @param keyword
     * @return
     */
    List<ProductSort> selectProductSortListByPage(String keyword);

    /**
     * 新增商品分类
     * @param productSort
     * @return
     */
    int addProductSort(ProductSort productSort);

    /**
     * 更新商品分类
     * @param productSort
     * @return
     */
    int updateProductSort(ProductSort productSort);

    /**
     * 查询商品分类所有父级
     * @return
     */
    List<ProductSort> getProductSortByParent();

    /**
     *
     * @param showStatus
     * @param id
     * @return
     */
    int changeSwitch(@Param("showStatus") Integer showStatus,
                     @Param("id") Long id);

}
