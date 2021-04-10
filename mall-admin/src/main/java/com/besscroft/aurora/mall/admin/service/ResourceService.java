package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.BmsAuthResource;

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
    List<BmsAuthResource> getResourcePageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取资源详情
     * @param id
     * @return
     */
    BmsAuthResource getResourceById(Long id);

    /**
     * 新增资源
     * @param bmsAuthResource
     * @return
     */
    boolean addResource(BmsAuthResource bmsAuthResource);

    /**
     * 更新资源信息
     * @param bmsAuthResource
     * @return
     */
    boolean updateResource(BmsAuthResource bmsAuthResource);

    /**
     * 根据id删除资源
     * @param id
     * @return
     */
    boolean delResource(Long id);

}
