package com.besscroft.aurora.mall.admin.api.fallback;

import com.besscroft.aurora.mall.admin.api.LogFeignClient;
import com.besscroft.aurora.mall.common.entity.WebLog;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/11/21 12:33
 */
@Slf4j
@Component
public class LogFeignFallbackClient implements LogFeignClient {

    @Override
    public AjaxResult mallLog(WebLog webLog) {
        log.error("feign远程调用系统用户服务异常后的降级方法");
        return AjaxResult.error(5001, "系统功能降级");
    }

    @Override
    public AjaxResult getWebLogList(Integer pageNum, Integer pageSize, String keyword) {
        log.error("feign远程调用系统用户服务异常后的降级方法");
        return AjaxResult.error(5001, "系统功能降级");
    }

}
