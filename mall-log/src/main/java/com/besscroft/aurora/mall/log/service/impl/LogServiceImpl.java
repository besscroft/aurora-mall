package com.besscroft.aurora.mall.log.service.impl;

import com.besscroft.aurora.mall.common.entity.WebLog;
import com.besscroft.aurora.mall.log.mapper.LogMapper;
import com.besscroft.aurora.mall.log.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author Bess Croft
 * @Time 2021/7/18 17:55
 */
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;

    @Override
    @Transactional
    public boolean saveWebLog(WebLog webLog) {
        return logMapper.insert(webLog) > 0;
    }
}
