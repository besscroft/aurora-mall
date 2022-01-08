package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.AuthResourceSort;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:54
 */
@SpringBootTest
public class ResourceSortServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceSortServiceTest.class);

    @Autowired
    private ResourceSortService resourceSortService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getResourcePageList() throws JsonProcessingException {
        List<AuthResourceSort> resourcePageList = resourceSortService.getResourcePageList(1, 10, "");
        assertNotNull(resourcePageList, "获取资源类别列表失败！");
        LOGGER.info("资源类别列表:{}", objectMapper.writeValueAsString(resourcePageList));
    }

    @Test
    void getResourceSortById() throws JsonProcessingException {
        Long resourceSortId = 1L;
        AuthResourceSort resourceSort = resourceSortService.getResourceSortById(resourceSortId);
        assertNotNull(resourceSort, "获取资源类别详情失败！");
        LOGGER.info("资源类别详情:{}", objectMapper.writeValueAsString(resourceSort));
    }

    @Test
    void addResourceSort() {
        AuthResourceSort authResourceSort = AuthResourceSort.builder()
                .createTime(LocalDateTime.now())
                .categoryName("单元测试类别")
                .description("单元测试类别描述")
                .sort(10L).build();
        boolean b = resourceSortService.addResourceSort(authResourceSort);
        assertTrue(b, "新增资源类别失败！");
    }

    @Test
    void updateResourceSort() {
        AuthResourceSort authResourceSort = AuthResourceSort.builder()
                .id(1000L)
                .createTime(LocalDateTime.now())
                .categoryName("单元测试类别")
                .description("单元测试类别描述")
                .sort(10L).build();
        boolean b = resourceSortService.updateResourceSort(authResourceSort);
        assertTrue(b, "更新资源类别失败！");
    }

    @Test
    void delResourceSort() {
        List<Long> ids = Collections.singletonList(1000L);
        boolean b = resourceSortService.delResourceSort(ids);
        assertTrue(b, "删除资源类别失败！");
    }

}
