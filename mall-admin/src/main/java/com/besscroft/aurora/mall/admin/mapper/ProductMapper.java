package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.Product;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/15 19:27
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 根据条件查询所又商品
     * @param keyword
     * @return
     */
    List<Product> selectProductListByPage(String keyword);

}
