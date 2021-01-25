package com.besscroft.aurora.mall.auth.mapper;

import com.besscroft.aurora.mall.common.entity.BmsAuthResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/1/23 17:15
 */
public interface BmsAuthResourceMapper {

    /**
     * 根据id获取用户所有可访问资源
     */
    List<BmsAuthResource> selectBmsAuthResourceListById(@Param("id") Long Id);

}
