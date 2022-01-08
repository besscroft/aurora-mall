package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.UpdateLog;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:50
 */
@SpringBootTest
public class UpdateLogServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UpdateLogServiceTest.class);

    @Autowired
    private UpdateLogService updateLogService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getUpdateLogList() throws Exception {
        List<UpdateLog> list = updateLogService.getUpdateLogList();
        assertNotNull(list, "获取版本日志列表失败！");
        LOGGER.info("所有的版本日志:{}", objectMapper.writeValueAsString(list));
    }

}
