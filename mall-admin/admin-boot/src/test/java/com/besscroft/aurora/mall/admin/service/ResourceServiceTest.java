package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.domain.param.ResourceParam;
import com.besscroft.aurora.mall.common.entity.AuthResource;
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
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Author Bess Croft
 * @Time 2021/9/5 17:55
 */
@SpringBootTest
public class ResourceServiceTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResourceServiceTest.class);

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void initRoleResourceMap() throws JsonProcessingException {
        Map<String, List<String>> roleResourceMap = resourceService.initRoleResourceMap();
        assertNotNull(roleResourceMap, "初始化资源角色规则失败！");
        LOGGER.info("资源角色规则:{}", objectMapper.writeValueAsString(roleResourceMap));
    }

    @Test
    void getResourcePageList() throws JsonProcessingException {
        List<AuthResource> resourcePageList = resourceService.getResourcePageList(1, 10, "");
        assertNotNull(resourcePageList, "获取资源列表失败！");
        LOGGER.info("资源列表:{}", objectMapper.writeValueAsString(resourcePageList));
    }

    @Test
    void getResourceById() throws JsonProcessingException {
        Long resourceId = 1L;
        AuthResource resource = resourceService.getResourceById(resourceId);
        assertNotNull(resource, "获取资源详情失败！");
        LOGGER.info("资源详情:{}", objectMapper.writeValueAsString(resource));
    }

    @Test
    void addResource() {
        AuthResource authResource = AuthResource.builder()
                .name("测试资源")
                .url("baodu.com")
                .description("测试专用资源")
                .createTime(LocalDateTime.now())
                .categoryId(1L).build();
        boolean b = resourceService.addResource(authResource);
        assertTrue(b, "新增资源失败！");
    }

    @Test
    void updateResource() {
        AuthResource authResource = AuthResource.builder()
                .id(1000L)
                .name("测试资源")
                .url("baodu.com")
                .description("测试专用资源")
                .createTime(LocalDateTime.now())
                .categoryId(1L).build();
        boolean b = resourceService.updateResource(authResource);
        assertTrue(b, "更新资源失败！");
    }

    @Test
    void delResource() {
        List<Long> ids = Collections.singletonList(1000L);
        boolean b = resourceService.delResource(ids);
        assertTrue(b, "删除资源失败！");
    }

    @Test
    void getAllResourceTree() throws JsonProcessingException {
        List<ResourceParam> allResourceTree = resourceService.getAllResourceTree();
        assertNotNull(allResourceTree, "获取资源树失败！");
        LOGGER.info("资源树:{}", objectMapper.writeValueAsString(allResourceTree));
    }

    @Test
    void getResourceTreeById() throws JsonProcessingException {
        Long roleId = 1L;
        List<Long> longs = resourceService.getResourceTreeById(roleId);
        assertNotNull(longs, "获取角色资源数组失败！");
        LOGGER.info("角色资源数组:{}", objectMapper.writeValueAsString(longs));
    }

    @Test
    void updateResourceTree() {
        List<Long> resourceIds = Collections.singletonList(10000L);
        Long roleId = 10L;
        boolean b = resourceService.updateResourceTree(resourceIds, roleId);
        assertTrue(b, "批量更新资源树失败！");
    }

}
