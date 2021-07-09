package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.AuthResourceSort;

import java.util.List;

/**
 * 后台管理资源类别服务
 *
 * @Author Besscroft
 * @Date 2021/4/17 19:04
 */
public interface ResourceSortService {

    /**
     * 分页查询资源类别列表
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return 分页资源类型列表
     */
    List<AuthResourceSort> getResourcePageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取资源类别详情
     * @param id 资源类别id
     * @return 资源类别实体
     */
    AuthResourceSort getResourceSortById(Long id);

    /**
     * 新增资源类别
     * @param authResourceSort 资源类别实体
     * @return
     */
    boolean addResourceSort(AuthResourceSort authResourceSort);

    /**
     * 修改资源类别
     * @param authResourceSort 资源类别实体
     * @return
     */
    boolean updateResourceSort(AuthResourceSort authResourceSort);

    /**
     * 删除资源类别
     * @param ids 资源类别id集合
     * @return
     */
    boolean delResourceSort(List<Long> ids);

}
