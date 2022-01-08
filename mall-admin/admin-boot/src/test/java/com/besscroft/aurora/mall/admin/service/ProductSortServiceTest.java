package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.ProductSort;
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
public class ProductSortServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductSortServiceTest.class);

    @Autowired
    private ProductSortService productSortService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getProductSortPageList() throws JsonProcessingException {
        List<ProductSort> productSortPageList = productSortService.getProductSortPageList(1, 10, "");
        assertNotNull(productSortPageList, "获取商品分类列表失败！");
        LOGGER.info("商品分类列表:{}", objectMapper.writeValueAsString(productSortPageList));
    }

    @Test
    void getProductSortById() throws JsonProcessingException {
        String productSortId = "10";
        ProductSort productSort = productSortService.getProductSortById(productSortId);
        assertNotNull(productSort, "获取商品分类详情失败！");
        LOGGER.info("商品分类详情:{}", objectMapper.writeValueAsString(productSort));
    }

    @Test
    void addProductSort() {
        ProductSort productSort = ProductSort.builder()
                .name("测试商品分类")
                .level(0)
                .showStatus(0)
                .sort(10L)
                .description("测试商品分类专用").build();
        boolean b = productSortService.addProductSort(productSort);
        assertTrue(b, "新增商品分类失败！");
    }

    @Test
    void updateProductSort() {
        ProductSort productSort = ProductSort.builder()
                .id("666")
                .name("测试商品分类")
                .level(0)
                .showStatus(0)
                .sort(10L)
                .description("测试更新商品分类专用").build();
        boolean b = productSortService.updateProductSort(productSort);
        assertTrue(b, "更新商品分类失败！");
    }

    @Test
    void delProductSort() {
        List<String> ids = Collections.singletonList("666");
        boolean b = productSortService.delProductSort(ids);
        assertTrue(b, "删除商品分类失败！");
    }

    @Test
    void getProductSortByParent() throws JsonProcessingException {
        List<ProductSort> productSortList = productSortService.getProductSortByParent();
        assertNotNull(productSortList, "获取商品分类所有父级失败！");
        LOGGER.info("商品分类所有父级:{}", objectMapper.writeValueAsString(productSortList));
    }

    @Test
    void changeSwitch() {
        boolean showStatus = true;
        String productSortId = "666";
        boolean b = productSortService.changeSwitch(showStatus, productSortId);
        assertTrue(b, "修改商品分类显示状态失败！");
    }

    @Test
    void getProductSortDict() {
        List<Map<String, String>> productSortDict = productSortService.getProductSortDict();
        assertNotNull(productSortDict, "获取商品分类字典失败！");
        LOGGER.info("商品分类字典:{}", productSortDict);
    }

}
