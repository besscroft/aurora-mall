package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.ProductTypeMapper;
import com.besscroft.aurora.mall.admin.service.ProductTypeService;
import com.besscroft.aurora.mall.common.entity.ProductType;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/10 14:16
 */
@Service
public class ProductTypeServiceImpl implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getProductTypePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductType> resources = productTypeMapper.selectProductTypeListByPage(keyword);
        return resources;
    }

    @Override
    public ProductType getProductTypeById(Long id) {
        return productTypeMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addProductType(ProductType productType) {
        return productTypeMapper.addProductType(productType) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProductType(ProductType productType) {
        return productTypeMapper.updateProductType(productType) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delProductType(List<Long> ids) {
        ids.forEach(id -> {
            productTypeMapper.deleteById(id);
        });
        return true;
    }

}
