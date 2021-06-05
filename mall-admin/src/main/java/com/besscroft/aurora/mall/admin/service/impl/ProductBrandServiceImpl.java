package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.ProductBrandMapper;
import com.besscroft.aurora.mall.admin.service.ProductBrandService;
import com.besscroft.aurora.mall.common.entity.ProductBrand;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/15 14:42
 */
@Service
public class ProductBrandServiceImpl implements ProductBrandService {

    @Autowired
    private ProductBrandMapper productBrandMapper;

    @Override
    public List<ProductBrand> getProductBrandPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<ProductBrand> list = productBrandMapper.selectProductBrandListByPage(keyword);
        return list;
    }

    @Override
    public ProductBrand getProductBrandById(Long id) {
        return productBrandMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addProductBrand(ProductBrand productBrand) {
        return productBrandMapper.addProductBrand(productBrand) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProductBrand(ProductBrand productBrand) {
        return productBrandMapper.updateProductBrand(productBrand) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delProductBrand(List<Long> ids) {
        ids.forEach(id -> {
            productBrandMapper.deleteById(id);
        });
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitch(boolean showStatus, Long id) {
        if (showStatus) {
            return productBrandMapper.changeSwitch(1, id) > 0;
        }
        return productBrandMapper.changeSwitch(0, id) > 0;
    }

}
