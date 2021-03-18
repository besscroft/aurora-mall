package com.besscroft.aurora.mall.admin.service;

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

}
