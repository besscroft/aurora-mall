package com.besscroft.aurora.mall.log.controller;

import cn.hutool.json.JSONUtil;
import com.besscroft.aurora.mall.common.entity.WebLog;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.log.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Bess Croft
 * @Time 2021/7/18 18:09
 */
@Slf4j
@Api(tags = "日志服务内部接口")
@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @ApiOperation(value = "新增日志接口")
    @PostMapping(value = "/mallLog")
    public AjaxResult mallLog(@Validated @RequestBody WebLog webLog) {
        log.info("请求进来了, 日志信息:{}", JSONUtil.toJsonStr(webLog));
        boolean result = logService.saveWebLog(webLog);
        return AjaxResult.success(result);
    }

}
