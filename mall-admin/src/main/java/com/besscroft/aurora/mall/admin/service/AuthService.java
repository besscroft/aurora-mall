package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.result.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 认证中心请求服务
 *
 * @Author Besscroft
 * @Date 2021/2/17 18:15
 */
@FeignClient("mall-auth")
public interface AuthService {

    /**
     * 获取Oauth2Token
     * @param parameters 请求参数
     * @return Oauth2Token
     */
    @PostMapping(value = "/oauth/token")
    AjaxResult getAccessToken(@RequestParam Map<String, String> parameters);

}
