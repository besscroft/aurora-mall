package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.ProductSortMapper;
import com.besscroft.aurora.mall.admin.service.ProductSortService;
import com.besscroft.aurora.mall.common.entity.ProductSort;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/5/7 14:30
 */
@Service
public class ProductSortServiceImpl implements ProductSortService {

    @Autowired
    private ProductSortMapper productSortMapper;

    @Override
    public List<ProductSort> getProductSortPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return productSortMapper.selectProductSortListByPage(keyword);
    }

    @Override
    public ProductSort getProductSortById(Long id) {
        return productSortMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addProductSort(ProductSort productSort) {
        if (productSort.getLevel() == 0) {
            productSort.setParentId(0L);
        }
        return productSortMapper.addProductSort(productSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProductSort(ProductSort productSort) {
        if (productSort.getLevel() == 0) {
            productSort.setParentId(0L);
        }
        return productSortMapper.updateProductSort(productSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delProductSort(List<Long> ids) {
        return productSortMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public List<ProductSort> getProductSortByParent() {
        return productSortMapper.getProductSortByParent();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitch(boolean showStatus, Long id) {
        if (showStatus) {
            return productSortMapper.changeSwitch(1, id) > 0;
        }
        return productSortMapper.changeSwitch(0, id) > 0;
    }

}
