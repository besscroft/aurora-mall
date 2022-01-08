package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.ProductBrand;
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
 * @Time 2021/9/5 17:56
 */
@SpringBootTest
public class ProductBrandServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBrandServiceTest.class);

    @Autowired
    private ProductBrandService productBrandService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getProductBrandPageList() throws JsonProcessingException {
        List<ProductBrand> productBrandPageList = productBrandService.getProductBrandPageList(1, 10, "");
        assertNotNull(productBrandPageList, "获取商品品牌列表失败！");
        LOGGER.info("商品品牌列表:{}", objectMapper.writeValueAsString(productBrandPageList));
    }

    @Test
    void getProductBrandById() throws JsonProcessingException {
        String productBrandId = "1";
        ProductBrand productBrand = productBrandService.getProductBrandById(productBrandId);
        assertNotNull(productBrand, "获取商品品牌详情失败！");
        LOGGER.info("商品品牌详情:{}", objectMapper.writeValueAsString(productBrand));
    }

    @Test
    void addProductBrand() {
        ProductBrand productBrand = ProductBrand.builder()
                .name("测试品牌名称")
                .showStatus(0)
                .sort(10L).build();
        boolean b = productBrandService.addProductBrand(productBrand);
        assertTrue(b, "新增商品品牌失败！");
    }

    @Test
    void updateProductType() {
        ProductBrand productBrand = ProductBrand.builder()
                .id("666")
                .name("测试更新品牌名称")
                .showStatus(0)
                .sort(10L).build();
        boolean b = productBrandService.updateProductBrand(productBrand);
        assertTrue(b, "更新商品品牌失败！");
    }

    @Test
    void delProductBrand() {
        List<String> ids = Collections.singletonList("666");
        boolean b = productBrandService.delProductBrand(ids);
        assertTrue(b, "删除商品品牌失败！");
    }

    @Test
    void changeSwitch() {
        boolean showStatus = true;
        String productBrandId = "666";
        boolean b = productBrandService.changeSwitch(showStatus, productBrandId);
        assertTrue(b, "修改商品品牌显示状态失败！");
    }

    @Test
    public void getProductBrandDict() throws JsonProcessingException {
        List<Map<String, String>> list = productBrandService.getProductBrandDict();
        assertNotNull(list, "获取商品品牌字典失败！");
        LOGGER.info("商品品牌字典:{}", objectMapper.writeValueAsString(list));
    }

}
