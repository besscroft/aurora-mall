package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.ProductMapper;
import com.besscroft.aurora.mall.admin.service.ProductService;
import com.besscroft.aurora.mall.common.entity.Product;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/15 19:26
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> getProductPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<Product> products = productMapper.selectProductListByPage(keyword);
        return products;
    }

}
