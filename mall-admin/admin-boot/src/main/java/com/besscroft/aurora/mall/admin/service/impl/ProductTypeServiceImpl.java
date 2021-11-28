package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.ProductTypeMapper;
import com.besscroft.aurora.mall.admin.service.ProductTypeService;
import com.besscroft.aurora.mall.common.entity.ProductType;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author Bess Croft
 * @Date 2021/5/10 14:16
 */
@Service
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements ProductTypeService {

    @Override
    public List<ProductType> getProductTypePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectProductTypeListByPage(keyword);
    }

    @Override
    public ProductType getProductTypeById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addProductType(ProductType productType) {
        productType.setId("PT" + IdUtil.simpleUUID());
        return this.baseMapper.addProductType(productType) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProductType(ProductType productType) {
        return this.baseMapper.updateProductType(productType) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delProductType(List<String> ids) {
        return this.baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public List<Map<String, String>> getProductTypeDict() {
        List<ProductType> list = this.list();
        if (CollUtil.isNotEmpty(list)) {
            List<Map<String, String>> mapArrayList = new ArrayList<>();
            list.forEach(productType -> {
                Map<String, String> map = new HashMap();
                map.put("productTypeId", productType.getId());
                map.put("productTypeName", productType.getName());
                mapArrayList.add(map);
            });
            return mapArrayList;
        }
        return null;
    }

}
