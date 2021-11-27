package com.besscroft.aurora.mall.admin.converter;

import com.besscroft.aurora.mall.common.domain.ProductExcelDto;
import com.besscroft.aurora.mall.common.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @Description 商品对象转换器
 * @Author Bess Croft
 * @Time 2021/10/14 14:28
 */
@Mapper(componentModel = "spring")
public interface ProductConverterMapper {

    ProductConverterMapper INSTANCE = Mappers.getMapper(ProductConverterMapper.class);

    @Mappings({
            @Mapping(source = "createUserId", target = "createUser"),
            @Mapping(target = "pushStatus", expression = "java(IntegerToString(product.getPushStatus()))"),
            @Mapping(target = "newStatus", expression = "java(IntegerToString(product.getNewStatus()))"),
            @Mapping(target = "recommandStatus", expression = "java(IntegerToString(product.getRecommandStatus()))"),
            @Mapping(target = "verifyStatus", expression = "java(IntegerToString(product.getVerifyStatus()))"),
            @Mapping(target = "deleteStatus", expression = "java(IntegerToString(product.getDeleteStatus()))"),
            @Mapping(target = "previewStatus", expression = "java(IntegerToString(product.getPreviewStatus()))")
    })
    ProductExcelDto productToProductExcelDto(Product product);

    List<ProductExcelDto> productToProductExcelListDto(List<Product> productList);

    default String IntegerToString(Integer source) {
        return String.valueOf(source);
    }

}
