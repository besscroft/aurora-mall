package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.domain.dto.UserInfoDetailDto;
import com.besscroft.aurora.mall.common.entity.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2022/1/8 11:56
 */
@SpringBootTest
public class MallUserServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MallUserServiceTest.class);

    @Autowired
    private MallUserService mallUserService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getUserList() throws JsonProcessingException {
        List<UserInfo> userList = mallUserService.getUserList(1, 10);
        assertNotNull(userList, "获取用户列表失败！");
        LOGGER.info("用户列表:{}", objectMapper.writeValueAsString(userList));
    }

    @Test
    void getUserDetail() throws JsonProcessingException {
        String userId = "1";
        UserInfoDetailDto userInfo = mallUserService.getUserDetail(userId);
        assertNotNull(userInfo, "获取用户详情失败！");
        LOGGER.info("用户详情:{}", objectMapper.writeValueAsString(userInfo));
    }

}
