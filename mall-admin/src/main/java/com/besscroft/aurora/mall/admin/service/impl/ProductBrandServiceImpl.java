package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.ProductBrandMapper;
import com.besscroft.aurora.mall.admin.service.ProductBrandService;
import com.besscroft.aurora.mall.common.entity.ProductBrand;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Bess Croft
 * @Date 2021/5/15 14:42
 */
@Service
public class ProductBrandServiceImpl extends ServiceImpl<ProductBrandMapper, ProductBrand> implements ProductBrandService {

    @Override
    public List<ProductBrand> getProductBrandPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectProductBrandListByPage(keyword);
    }

    @Override
    public ProductBrand getProductBrandById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addProductBrand(ProductBrand productBrand) {
        productBrand.setId("PB" + IdUtil.simpleUUID());
        return this.baseMapper.addProductBrand(productBrand) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProductBrand(ProductBrand productBrand) {
        return this.baseMapper.updateProductBrand(productBrand) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delProductBrand(List<String> ids) {
        return this.baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitch(boolean showStatus, String id) {
        if (showStatus) {
            return this.baseMapper.changeSwitch(1, id) > 0;
        }
        return this.baseMapper.changeSwitch(0, id) > 0;
    }

}
