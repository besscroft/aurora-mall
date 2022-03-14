package com.besscroft.aurora.mall.log.controller;

import cn.hutool.json.JSONUtil;
import com.besscroft.aurora.mall.common.entity.WebLog;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import com.besscroft.aurora.mall.common.util.CommonPage;
import com.besscroft.aurora.mall.log.service.LogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Bess Croft
 * @Time 2021/7/18 18:09
 */
@Slf4j
@Api(tags = "日志服务内部接口")
@RestController
@RequiredArgsConstructor
@RequestMapping("/log")
public class LogController {

    private final LogService logService;

    @ApiOperation(value = "新增日志接口")
    @PostMapping(value = "/mallLog")
    public AjaxResult mallLog(@Validated @RequestBody WebLog webLog) {
        log.info("请求进来了, 日志信息:{}", JSONUtil.toJsonStr(webLog));
        boolean result = logService.saveWebLog(webLog);
        return AjaxResult.success(result);
    }

    @ApiOperation(value = "访问日志列表接口")
    @GetMapping(value = "/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "keyword", value = "关键字", dataType = "String")
    })
    public AjaxResult list(@RequestParam(value = "pageNum") Integer pageNum,
                           @RequestParam(value = "pageSize") Integer pageSize,
                           @RequestParam(value = "keyword") String keyword) {
        List<WebLog> webLogList = logService.pageList(pageNum, pageSize, keyword);
        return AjaxResult.success(CommonPage.restPage(webLogList));
    }

}
