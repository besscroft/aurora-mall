package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.admin.dto.ResourceParam;
import com.besscroft.aurora.mall.common.entity.AuthResource;

import java.util.List;
import java.util.Map;

/**
 * 后台管理系统资源服务
 *
 * @Author Besscroft
 * @Date 2021/3/17 15:48
 */
public interface ResourceService {

    /**
     * 初始化资源角色规则
     * @return 资源角色规则
     */
    Map<String, List<String>> initRoleResourceMap();

    /**
     * 分页查询资源列表
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页资源列表
     */
    List<AuthResource> getResourcePageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取资源详情
     * @param id 资源id
     * @return 资源实体
     */
    AuthResource getResourceById(Long id);

    /**
     * 新增资源
     * @param authResource 资源实体
     * @return
     */
    boolean addResource(AuthResource authResource);

    /**
     * 更新资源信息
     * @param authResource 资源实体
     * @return
     */
    boolean updateResource(AuthResource authResource);

    /**
     * 根据id删除资源
     * @param ids 资源id集合
     * @return
     */
    boolean delResource(List<Long> ids);

    /**
     * 获取所有资源的资源树
     * @return 所有的资源树集合
     */
    List<ResourceParam> getAllResourceTree();

    /**
     * 根据角色id获取资源树数组
     * @param id 角色id
     * @return 资源树数组
     */
    List<Long> getResourceTreeById(Long id);

    /**
     * 批量更新资源树
     * @param data 资源id集合
     * @param id 角色id
     * @return
     */
    boolean updateResourceTree(List<Long> data, Long id);

}
