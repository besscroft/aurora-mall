package com.besscroft.aurora.mall.gateway.service;

import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.gateway.service.fallback.AdminFeignFallbackClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/12/24 15:11
 */
@FeignClient(value = "mall-admin", fallback = AdminFeignFallbackClient.class)
public interface AdminFeignClient {

    /**
     * 请求初始化资源角色规则接口
     * @return
     */
    @GetMapping(value = "/resource/initRoleResourceMap")
    AjaxResult initRoleResourceMap();

}
