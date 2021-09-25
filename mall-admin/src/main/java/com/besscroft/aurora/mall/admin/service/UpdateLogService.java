package com.besscroft.aurora.mall.admin.service;

import com.besscroft.aurora.mall.common.entity.UpdateLog;

import java.util.List;

/**
 * 版本日志服务
 *
 * @Author Bess Croft
 * @Date 2021/4/17 21:32
 */
public interface UpdateLogService {

    /**
     * 获取所有的版本日志
     * @return 版本日志集合
     */
    List<UpdateLog> getUpdateLogList();

}
