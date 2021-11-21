package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.api.LogFeignClient;
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
public class LogServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceTest.class);

    @Autowired
    private LogFeignClient logFeignClient;

    @Autowired
    private ObjectMapper objectMapper;

}
