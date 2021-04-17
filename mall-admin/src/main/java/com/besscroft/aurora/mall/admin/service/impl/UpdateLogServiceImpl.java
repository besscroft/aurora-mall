package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.besscroft.aurora.mall.admin.mapper.BmsUpdateLogDetailMapper;
import com.besscroft.aurora.mall.admin.mapper.BmsUpdateLogMapper;
import com.besscroft.aurora.mall.admin.service.UpdateLogService;
import com.besscroft.aurora.mall.common.entity.BmsUpdateLog;
import com.besscroft.aurora.mall.common.entity.BmsUpdateLogDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/17 21:33
 */
@Service
public class UpdateLogServiceImpl implements UpdateLogService {

    @Autowired
    private BmsUpdateLogMapper bmsUpdateLogMapper;

    @Autowired
    private BmsUpdateLogDetailMapper bmsUpdateLogDetailMapper;

    @Override
    public List<BmsUpdateLog> getUpdateLogList() {
        List<BmsUpdateLog> updateLogs = bmsUpdateLogMapper.selectAllList();
        updateLogs.forEach(updateLog -> {
            QueryWrapper<BmsUpdateLogDetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("log_id", updateLog.getId());
            List<BmsUpdateLogDetail> updateLogDetails = bmsUpdateLogDetailMapper.selectList(queryWrapper);
            updateLog.setDetail(updateLogDetails);
        });
        return updateLogs;
    }

}
