package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.AuthResourceSort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台管理资源类别持久化
 *
 * @Author Bess Croft
 * @Date 2021/4/16 15:43
 */
public interface AuthResourceSortMapper extends BaseMapper<AuthResourceSort> {

    /**
     * 分页查询资源类别列表
     * @param keyword 关键字
     * @return 分页资源类别列表
     */
    List<AuthResourceSort> selectResourceSortListByPage(@Param("keyword") String keyword);

    /**
     * 新增资源类别
     * @param authResourceSort 资源类别实体
     * @return
     */
    int addResourceSort(AuthResourceSort authResourceSort);

    /**
     * 更新资源类别
     * @param authResourceSort 资源类别实体
     * @return
     */
    int updateResourceSort(AuthResourceSort authResourceSort);

}
