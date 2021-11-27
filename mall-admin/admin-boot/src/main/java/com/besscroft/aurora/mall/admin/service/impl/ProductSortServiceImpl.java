package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.ProductSortMapper;
import com.besscroft.aurora.mall.admin.service.ProductSortService;
import com.besscroft.aurora.mall.common.entity.ProductSort;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Author Bess Croft
 * @Date 2021/5/7 14:30
 */
@Service
public class ProductSortServiceImpl extends ServiceImpl<ProductSortMapper, ProductSort> implements ProductSortService {

    @Override
    public List<ProductSort> getProductSortPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectProductSortListByPage(keyword);
    }

    @Override
    public ProductSort getProductSortById(String id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addProductSort(ProductSort productSort) {
        if (Objects.equals(productSort.getLevel(), 0)) {
            productSort.setParentId("0");
        }
        productSort.setId("PS" + IdUtil.simpleUUID());
        return this.baseMapper.addProductSort(productSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProductSort(ProductSort productSort) {
        if (Objects.equals(productSort.getLevel(), 0)) {
            productSort.setParentId("0");
        }
        return this.baseMapper.updateProductSort(productSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delProductSort(List<String> ids) {
        return this.baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    public List<ProductSort> getProductSortByParent() {
        return this.baseMapper.getProductSortByParent();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitch(boolean showStatus, String id) {
        if (showStatus) {
            return this.baseMapper.changeSwitch(1, id) > 0;
        }
        return this.baseMapper.changeSwitch(0, id) > 0;
    }

    @Override
    public Map<String, String> getProductSortDict() {
        List<ProductSort> list = this.list();
        if (CollUtil.isNotEmpty(list)) {
            Map<String, String> map = list.stream().collect(Collectors.toMap(
                    productSort -> productSort.getId(), productSort -> productSort.getName()
            ));
            return map;
        }
        return null;
    }

}
