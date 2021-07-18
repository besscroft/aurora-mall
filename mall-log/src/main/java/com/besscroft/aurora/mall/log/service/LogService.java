package com.besscroft.aurora.mall.log.service;

import com.besscroft.aurora.mall.common.entity.WebLog;

/**
 * 日志服务
 *
 * @Author Bess Croft
 * @Time 2021/7/18 17:55
 */
public interface LogService {

    /**
     * 保存web日志
     * @param webLog
     * @return
     */
    boolean saveWebLog(WebLog webLog);

}
