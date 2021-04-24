package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.AuthResourceSort;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/16 15:43
 */
public interface AuthResourceSortMapper extends BaseMapper<AuthResourceSort> {

    /**
     * 分页查询资源列表
     * @param keyword
     * @return
     */
    List<AuthResourceSort> selectResourceSortListByPage(String keyword);

    /**
     * 新增资源类别
     * @param authResourceSort
     * @return
     */
    int addResourceSort(AuthResourceSort authResourceSort);

    /**
     * 更新资源类别
     * @param authResourceSort
     * @return
     */
    int updateResourceSort(AuthResourceSort authResourceSort);

}
