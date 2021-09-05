package com.besscroft.aurora.mall.admin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
