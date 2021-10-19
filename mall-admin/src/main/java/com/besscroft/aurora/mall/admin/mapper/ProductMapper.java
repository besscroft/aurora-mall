package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台管理商品持久化
 *
 * @Author Bess Croft
 * @Date 2021/5/15 19:27
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 根据条件查询所有商品
     * @param keyword 关键字
     * @return 分页商品列表
     */
    List<Product> selectProductListByPage(String keyword);

    /**
     * 商品软删除
     * @param id
     * @return
     */
    int deleteByProductId(@Param("id") String id);

    /**
     * 修改商品状态
     * @param pushStatus 上架
     * @param newStatus 新品
     * @param recommandStatus 推荐
     * @param id 菜单id
     * @return
     */
    int changeSwitch(@Param("pushStatus") Integer pushStatus,
                     @Param("newStatus") Integer newStatus,
                     @Param("recommandStatus") Integer recommandStatus,
                     @Param("id") String id);

}
