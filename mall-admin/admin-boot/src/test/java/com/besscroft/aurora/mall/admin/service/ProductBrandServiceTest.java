package com.besscroft.aurora.mall.admin.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:56
 */
@Slf4j
@SpringBootTest
public class ProductBrandServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductBrandServiceTest.class);

    @Autowired
    private ProductBrandService productBrandService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getProductBrandDict() {
        Map<String, String> map = productBrandService.getProductBrandDict();
        try {
            String string = objectMapper.writeValueAsString(map);
            log.info("商品品牌字典:{}", string);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
