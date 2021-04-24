package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.dto.ResourceParam;
import com.besscroft.aurora.mall.common.entity.AuthResource;

import java.util.List;
import java.util.Map;

/**
 * 后台管理系统资源管理
 *
 * @Author Besscroft
 * @Date 2021/3/17 15:48
 */
public interface ResourceService {

    /**
     * 初始化资源角色规则
     * @return
     */
    Map<String, List<String>> initRoleResourceMap();

    /**
     * 分页查询资源列表
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    List<AuthResource> getResourcePageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取资源详情
     * @param id
     * @return
     */
    AuthResource getResourceById(Long id);

    /**
     * 新增资源
     * @param authResource
     * @return
     */
    boolean addResource(AuthResource authResource);

    /**
     * 更新资源信息
     * @param authResource
     * @return
     */
    boolean updateResource(AuthResource authResource);

    /**
     * 根据id删除资源
     * @param id
     * @return
     */
    boolean delResource(Long id);

    /**
     * 获取所有资源的资源树
     * @return
     */
    List<ResourceParam> getAllResourceTree();

    /**
     * 根据角色id获取资源树数组
     * @return
     */
    List<Long> getResourceTreeById(Long id);

    /**
     * 批量更新资源树
     * @param data
     * @param id
     * @return
     */
    boolean updateResourceTree(List<Long> data, Long id);

}
