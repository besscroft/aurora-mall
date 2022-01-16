package com.besscroft.aurora.mall.admin.api;

import com.besscroft.aurora.mall.admin.api.fallback.LogFeignFallbackClient;
import com.besscroft.aurora.mall.common.entity.WebLog;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description 日志服务
 * @Author Bess Croft
 * @Time 2021/11/21 12:33
 */
@FeignClient(value = "mall-log", fallback = LogFeignFallbackClient.class)
public interface LogFeignClient {

    /**
     * 请求日志服务接口，发送日志信息
     * @param webLog
     * @return
     */
    @PostMapping(value = "/log/mallLog")
    AjaxResult mallLog(@RequestBody WebLog webLog);

    @GetMapping(value = "/log/list")
    AjaxResult getWebLogList(@RequestParam(value = "pageNum") Integer pageNum,
                             @RequestParam(value = "pageSize") Integer pageSize,
                             @RequestParam(value = "keyword") String keyword);

}
