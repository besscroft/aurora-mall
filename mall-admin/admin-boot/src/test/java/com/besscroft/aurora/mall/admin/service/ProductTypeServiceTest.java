package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.ProductType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:55
 */
@SpringBootTest
public class ProductTypeServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductTypeServiceTest.class);

    @Autowired
    private ProductTypeService productTypeService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getProductTypePageList() throws JsonProcessingException {
        List<ProductType> productTypePageList = productTypeService.getProductTypePageList(1, 10, "");
        assertNotNull(productTypePageList, "获取商品类型列表失败！");
        LOGGER.info("商品类型列表:{}", objectMapper.writeValueAsString(productTypePageList));
    }

    @Test
    void getProductTypeById() throws JsonProcessingException {
        String productTypeId = "1";
        ProductType productType = productTypeService.getProductTypeById(productTypeId);
        assertNotNull(productType, "获取商品类型详情失败！");
        LOGGER.info("商品类型详情:{}", objectMapper.writeValueAsString(productType));
    }

    @Test
    void addProductType() {
        ProductType productType = ProductType.builder()
                .name("测试商品类型")
                .attributeCount(0L)
                .paramCount(0L).build();
        boolean b = productTypeService.addProductType(productType);
        assertTrue(b, "新增商品类型失败！");
    }

    @Test
    void updateProductType() {
        ProductType productType = ProductType.builder()
                .id("666")
                .name("测试商品类型更新")
                .attributeCount(0L)
                .paramCount(0L).build();
        boolean b = productTypeService.updateProductType(productType);
        assertTrue(b, "更新商品类型失败！");
    }

    @Test
    void delProductType() {
        List<String> ids = Collections.singletonList("666");
        boolean b = productTypeService.delProductType(ids);
        assertTrue(b, "删除商品失败！");
    }

    @Test
    void getProductTypeDict() throws JsonProcessingException {
        List<Map<String, String>> productTypeDict = productTypeService.getProductTypeDict();
        assertNotNull(productTypeDict, "获取商品类型字典失败！");
        LOGGER.info("商品类型字典:{}", objectMapper.writeValueAsString(productTypeDict));
    }

}
