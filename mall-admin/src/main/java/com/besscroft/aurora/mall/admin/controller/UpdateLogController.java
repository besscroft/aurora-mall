package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.service.UpdateLogService;
import com.besscroft.aurora.mall.common.entity.UpdateLog;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/17 21:31
 */
@Slf4j
@Api(tags = "系统更新日志接口")
@RestController
@RequestMapping("/updateLog")
public class UpdateLogController {

    @Autowired
    private UpdateLogService updateLogService;

    @ApiOperation("查询版本日志列表")
    @GetMapping("/list")
    public AjaxResult list() {
        List<UpdateLog> list = updateLogService.getUpdateLogList();
        return AjaxResult.success(list);
    }

}
