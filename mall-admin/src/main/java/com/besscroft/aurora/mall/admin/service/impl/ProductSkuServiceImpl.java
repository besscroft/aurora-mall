package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.ProductSkuMapper;
import com.besscroft.aurora.mall.admin.service.ProductSkuService;
import com.besscroft.aurora.mall.common.entity.ProductSku;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/10/24 19:43
 */
@Service
public class ProductSkuServiceImpl extends ServiceImpl<ProductSkuMapper, ProductSku> implements ProductSkuService {

    @Override
    public List<ProductSku> getProductSkuPageList(String productId, Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectProductSkuListByPage(productId, keyword);
    }

}
