package com.besscroft.aurora.mall.log.service;

import cn.hutool.core.util.IdUtil;
import com.besscroft.aurora.mall.common.entity.WebLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2022/1/16 16:22
 */
@SpringBootTest
public class LogServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogServiceTest.class);

    @Autowired
    private LogService logService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void saveWebLog(){
        WebLog webLog = WebLog.builder()
                .id(IdUtil.simpleUUID())
                .description("测试")
                .url("http://www.baidu.com")
                .requestArgs("{name:besscroft}")
                .responseArgs("{code:200}")
                .httpMethod("GET")
                .startTime(LocalDateTime.now())
                .spendTime(666L)
                .classMethod("com.besscroft.aurora.mall.log.service.LogServiceTest.saveWebLog")
                .username("besscroft")
                .ip("1.1.1.1").build();
        boolean b = logService.saveWebLog(webLog);
        assertTrue(b, "新增访问日志失败！");
    }

    @Test
    public void pageList() throws JsonProcessingException {
        Integer pageNum = 0;
        Integer pageSize = 10;
        String keyword = "";
        List<WebLog> webLogList = logService.pageList(pageNum, pageSize, keyword);
        assertNotNull(webLogList, "获取访问日志列表失败！");
        LOGGER.info("日志列表:{}", objectMapper.writeValueAsString(webLogList));
    }

}
