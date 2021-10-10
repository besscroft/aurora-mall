package com.besscroft.aurora.mall.admin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

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
    public void productDel() {
        boolean b = productService.productDel(1441761476536274946L);
        Assert.isTrue(b, "删除失败！");
    }

}
