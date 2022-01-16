package com.besscroft.aurora.mall.log.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.besscroft.aurora.mall.common.entity.WebLog;

import java.util.List;

/**
 * 日志服务
 *
 * @Author Bess Croft
 * @Time 2021/7/18 17:55
 */
public interface LogService extends IService<WebLog> {

    /**
     * 保存web日志
     * @param webLog
     * @return
     */
    boolean saveWebLog(WebLog webLog);

    /**
     * 分页查询访问日志
     * @param pageNum 页码
     * @param pageSize 页大小
     * @param keyword 关键字
     * @return
     */
    List<WebLog> pageList(Integer pageNum, Integer pageSize, String keyword);

}
