package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.ProductSort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台管理商品分类持久化
 *
 * @Author Bess Croft
 * @Date 2021/5/7 14:39
 */
public interface ProductSortMapper extends BaseMapper<ProductSort> {

    /**
     * 分页查询商品分类
     * @param keyword 关键字
     * @return 分页商品分类列表
     */
    List<ProductSort> selectProductSortListByPage(String keyword);

    /**
     * 新增商品分类
     * @param productSort 商品分类
     * @return
     */
    int addProductSort(ProductSort productSort);

    /**
     * 更新商品分类
     * @param productSort 商品分类
     * @return
     */
    int updateProductSort(ProductSort productSort);

    /**
     * 查询商品分类所有父级
     * @return 商品分类父级集合
     */
    List<ProductSort> getProductSortByParent();

    /**
     * 修改商品分类显示状态
     * @param showStatus 显示状态
     * @param id 商品分类id
     * @return
     */
    int changeSwitch(@Param("showStatus") Integer showStatus,
                     @Param("id") Long id);

}
