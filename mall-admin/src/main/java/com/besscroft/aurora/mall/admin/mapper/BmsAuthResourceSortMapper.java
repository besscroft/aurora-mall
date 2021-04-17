package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.BmsAuthResourceSort;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/16 15:43
 */
public interface BmsAuthResourceSortMapper extends BaseMapper<BmsAuthResourceSort> {

    /**
     * 分页查询资源列表
     * @param keyword
     * @return
     */
    List<BmsAuthResourceSort> selectResourceSortListByPage(String keyword);

    /**
     * 新增资源类别
     * @param bmsAuthResourceSort
     * @return
     */
    int addResourceSort(BmsAuthResourceSort bmsAuthResourceSort);

    /**
     * 更新资源类别
     * @param bmsAuthResourceSort
     * @return
     */
    int updateResourceSort(BmsAuthResourceSort bmsAuthResourceSort);

}
