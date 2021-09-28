package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.ProductTypeMapper;
import com.besscroft.aurora.mall.admin.service.ProductTypeService;
import com.besscroft.aurora.mall.common.entity.ProductType;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Bess Croft
 * @Date 2021/5/10 14:16
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements ProductTypeService {

    @Autowired
    private ProductTypeMapper productTypeMapper;

    @Override
    public List<ProductType> getProductTypePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return productTypeMapper.selectProductTypeListByPage(keyword);
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
        return productTypeMapper.deleteBatchIds(ids) > 0;
    }

}
