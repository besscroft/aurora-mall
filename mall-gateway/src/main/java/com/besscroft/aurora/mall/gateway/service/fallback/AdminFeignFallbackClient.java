package com.besscroft.aurora.mall.gateway.service.fallback;

import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.gateway.service.AdminFeignClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/12/24 15:13
 */
@Slf4j
@Component
public class AdminFeignFallbackClient implements AdminFeignClient {

    @Override
    public AjaxResult initRoleResourceMap() {
        log.error("feign远程调用初始化资源角色规则接口异常后的降级方法");
        return AjaxResult.error(5001, "系统功能降级");
    }

}
