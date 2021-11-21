package com.besscroft.aurora.mall.admin.component;

import com.besscroft.aurora.mall.admin.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 初始化时加载角色与资源的对应关系
 *
 * @Author Bess Croft
 * @Date 2021/3/17 16:31
 */
@Component
public class RoleResourceRulesHolder {

    @Autowired
    private ResourceService resourceService;

    @PostConstruct
    public void initRoleResourceMap() {
        resourceService.initRoleResourceMap();
    }
}
