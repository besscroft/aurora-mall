package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.BmsAuthResourceSort;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/17 19:04
 */
public interface ResourceSortService {

    /**
     * 分页查询资源类别列表
     * @param pageNum
     * @param pageSize
     * @param keyword
     * @return
     */
    List<BmsAuthResourceSort> getResourcePageList(Integer pageNum, Integer pageSize, String keyword);

    /**
     * 根据id获取资源类别详情
     * @param id
     * @return
     */
    BmsAuthResourceSort getResourceSortById(Long id);

    /**
     * 新增资源类别
     * @param bmsAuthResourceSort
     * @return
     */
    boolean addResourceSort(BmsAuthResourceSort bmsAuthResourceSort);

    /**
     * 修改资源类别
     * @param bmsAuthResourceSort
     * @return
     */
    boolean updateResourceSort(BmsAuthResourceSort bmsAuthResourceSort);

    /**
     * 删除资源类别
     * @param id
     * @return
     */
    boolean delResourceSort(Long id);

}
