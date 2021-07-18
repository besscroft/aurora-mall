package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.WebLog;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 日志服务
 *
 * @Author Bess Croft
 * @Time 2021/7/18 18:20
 */
@FeignClient("mall-log")
public interface LogService {

    /**
     * 请求日志服务接口，发送日志信息
     * @param webLog
     * @return
     */
    @PostMapping(value = "/log/mallLog")
    AjaxResult mallLog(@RequestBody WebLog webLog);

}
