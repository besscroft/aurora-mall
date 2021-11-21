package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.api.AuthFeignClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:57
 */
@SpringBootTest
public class AuthServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthServiceTest.class);

    @Autowired
    private AuthFeignClient authFeignClient;

    @Autowired
    private ObjectMapper objectMapper;

}
