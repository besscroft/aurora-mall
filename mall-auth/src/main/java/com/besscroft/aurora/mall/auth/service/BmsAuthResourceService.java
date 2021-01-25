package com.besscroft.aurora.mall.auth.service;

import com.besscroft.aurora.mall.common.entity.BmsAuthResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户资源管理Service
 *
 * @Author Besscroft
 * @Date 2021/1/23 17:13
 */
public interface BmsAuthResourceService {

    /**
     * 获取用户所有可访问资源
     */
    List<BmsAuthResource> getResourceList(@Param("id") Long Id);

}
