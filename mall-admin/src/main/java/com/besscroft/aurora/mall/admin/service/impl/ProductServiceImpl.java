package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.util.IdUtil;
import com.besscroft.aurora.mall.admin.mapper.ProductMapper;
import com.besscroft.aurora.mall.admin.service.ProductService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.entity.Product;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Bess Croft
 * @Date 2021/5/15 19:26
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<Product> getProductPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return productMapper.selectProductListByPage(keyword);
    }

    @Override
    @Transactional
    public boolean productAdd(Product product) {
        // 获取当前用户
        AuthUser currentAdmin = userService.getCurrentAdmin();
        // 设置商品唯一id
        product.setProductId("S" + IdUtil.simpleUUID());
        // 设置新增商品的用户
        product.setCreateUserId(currentAdmin.getId());
        return productMapper.insert(product) > 0;
    }

}
