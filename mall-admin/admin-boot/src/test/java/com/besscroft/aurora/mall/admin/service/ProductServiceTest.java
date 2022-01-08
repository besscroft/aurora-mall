package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:56
 */
@SpringBootTest
public class ProductServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceTest.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getProductPageList() throws JsonProcessingException {
        List<Product> productPageList = productService.getProductPageList(1, 10, "");
        assertNotNull(productPageList, "获取所有商品失败！");
        LOGGER.info("商品列表:{}", objectMapper.writeValueAsString(objectMapper));
    }

    @Test
    void productAdd() {
        Product product = Product.builder()
                .productSn("SP1440761476536274666")
                .name("测试商品")
                .pushStatus(0)
                .newStatus(0)
                .recommandStatus(0)
                .verifyStatus(0)
                .deleteStatus(0)
                .sort(10L)
                .price(new BigDecimal(100.00))
                .auroraPoint(100L)
                .auroraBit(1L)
                .subTitle("测试副标题")
                .description("测试商品描述")
                .unit("个")
                .weight(new BigDecimal(100))
                .previewStatus(0)
                .serviceIds("1,2,3,4")
                .detailTitle("测试产品详情标题")
                .detailHtml("测试产品详情网页内容")
                .detailMobileHtml("测试小程序端网页详情")
                .promotionPerLimit(1L)
                .createUserId(1L).build();
        boolean b = productService.productAdd(product);
        assertTrue(b, "新增商品失败！");
    }

    @Test
    void productDel() {
        boolean b = productService.productDel("");
        assertTrue(b, "删除失败！");
    }

    @Test
    void changeSwitchPush() {
        Integer hidden = 0;
        String productId = "SP1440761476536274666";
        boolean b = productService.changeSwitchPush(hidden, productId);
        assertTrue(b, "修改上架状态失败！");
    }

    @Test
    void changeSwitchNew() {
        Integer hidden = 0;
        String productId = "SP1440761476536274666";
        boolean b = productService.changeSwitchNew(hidden, productId);
        assertTrue(b, "修改新品状态失败！");
    }

    @Test
    void changeSwitchRecommend() {
        Integer hidden = 0;
        String productId = "SP1440761476536274666";
        boolean b = productService.changeSwitchRecommend(hidden, productId);
        assertTrue(b, "修改推荐状态失败！");
    }

}
