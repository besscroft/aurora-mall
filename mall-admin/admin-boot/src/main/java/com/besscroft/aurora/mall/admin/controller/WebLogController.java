package com.besscroft.aurora.mall.admin.controller;

import com.besscroft.aurora.mall.admin.api.LogFeignClient;
import com.besscroft.aurora.mall.common.result.AjaxResult;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2022/1/16 15:34
 */
@RestController
@RequestMapping("/weblog")
public class WebLogController {

    @Autowired
    private LogFeignClient logFeignClient;

    @ApiOperation(value = "访问日志列表接口")
    @GetMapping(value = "/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "pageNum", value = "第几页",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "多少条",required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "keyword", value = "关键字",required = false, dataType = "String")
    })
    public AjaxResult list(@RequestParam(value = "pageNum") Integer pageNum,
                           @RequestParam(value = "pageSize") Integer pageSize,
                           @RequestParam(value = "keyword") String keyword) {
        return logFeignClient.getWebLogList(pageNum, pageSize, keyword);
    }

}
