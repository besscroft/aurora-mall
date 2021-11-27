package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.converter.ProductSkuConverterMapper;
import com.besscroft.aurora.mall.admin.domain.param.ProductSkuAddParam;
import com.besscroft.aurora.mall.admin.domain.param.ProductSkuUpdateParam;
import com.besscroft.aurora.mall.admin.mapper.ProductSkuMapper;
import com.besscroft.aurora.mall.admin.service.ProductSkuService;
import com.besscroft.aurora.mall.common.entity.ProductSku;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public ProductSku getProductSkuById(String productSkuId) {
        return this.baseMapper.selectById(productSkuId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addProductSku(ProductSkuAddParam productSkuAddParam) {
        if (ObjectUtil.isNotNull(productSkuAddParam)) {
            ProductSku productSku = ProductSkuConverterMapper.INSTANCE.productSkuAddParamToProductSku(productSkuAddParam);
            // 设置商品套餐编码
            productSku.setSkuCode("SKU" + IdUtil.simpleUUID());
            return this.baseMapper.insert(productSku) > 0;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateProductSku(ProductSkuUpdateParam productSkuUpdateParam) {
        if (ObjectUtil.isNotNull(productSkuUpdateParam)) {
            ProductSku productSku = ProductSkuConverterMapper.INSTANCE.productSkuUpdateParamToProductSku(productSkuUpdateParam);
            return this.baseMapper.updateById(productSku) > 0;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean deleteProductSku(String productSkuId) {
        return this.baseMapper.deleteById(productSkuId) > 0;
    }

}
