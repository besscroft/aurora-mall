package com.besscroft.aurora.mall.admin.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:53
 */
@SpringBootTest
public class RoleServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceTest.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private ObjectMapper objectMapper;

}
