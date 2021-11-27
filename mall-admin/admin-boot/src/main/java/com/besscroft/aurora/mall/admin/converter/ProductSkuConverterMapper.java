package com.besscroft.aurora.mall.admin.converter;

import com.besscroft.aurora.mall.admin.domain.param.ProductSkuAddParam;
import com.besscroft.aurora.mall.admin.domain.param.ProductSkuUpdateParam;
import com.besscroft.aurora.mall.common.entity.ProductSku;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @Description 商品套餐对象转换器
 * @Author Bess Croft
 * @Time 2021/11/27 20:10
 */
@Mapper(componentModel = "spring")
public interface ProductSkuConverterMapper {

    ProductSkuConverterMapper INSTANCE = Mappers.getMapper(ProductSkuConverterMapper.class);

    ProductSku productSkuAddParamToProductSku(ProductSkuAddParam productSkuAddParam);

    ProductSku productSkuUpdateParamToProductSku(ProductSkuUpdateParam productSkuUpdateParam);

}
