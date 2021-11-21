package com.besscroft.aurora.mall.admin.api;

import com.besscroft.aurora.mall.admin.api.fallback.AuthFeignFallbackClient;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Description 认证中心请求服务
 * @Author Bess Croft
 * @Time 2021/11/21 12:18
 */
@FeignClient(value = "mall-auth", fallback = AuthFeignFallbackClient.class)
public interface AuthFeignClient {

    /**
     * 获取Oauth2Token
     * @param parameters 请求参数
     * @return Oauth2Token
     */
    @PostMapping(value = "/oauth/token")
    AjaxResult getAccessToken(@RequestParam Map<String, String> parameters);

}
