package com.besscroft.aurora.mall.admin.api.fallback;

import com.besscroft.aurora.mall.admin.api.AuthFeignClient;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/11/21 12:20
 */
@Slf4j
@Component
public class AuthFeignFallbackClient implements AuthFeignClient {

    @Override
    public AjaxResult getAccessToken(Map<String, String> parameters) {
        log.error("feign远程调用系统用户服务异常后的降级方法");
        return AjaxResult.error(5001, "系统功能降级");
    }

}
