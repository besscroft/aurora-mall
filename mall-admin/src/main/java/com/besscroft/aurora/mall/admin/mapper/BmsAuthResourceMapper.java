package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.BmsAuthResource;

import java.util.List;

/**
 * 权限管理模块资源Mapper接口
 *
 * @Author Besscroft
 * @Date 2021/3/17 15:51
 */
public interface BmsAuthResourceMapper extends BaseMapper<BmsAuthResource> {

    /**
     * 查询所有资源
     * @return
     */
    List<BmsAuthResource> selectAll();

    /**
     * 分页查询资源列表
     * @param keyword
     * @return
     */
    List<BmsAuthResource> selectResourceListByPage(String keyword);

    /**
     * 新增资源
     * @param bmsAuthResource
     * @return
     */
    int insertResource(BmsAuthResource bmsAuthResource);

    /**
     * 更新资源
     * @param bmsAuthResource
     * @return
     */
    int updateResource(BmsAuthResource bmsAuthResource);

}
