package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.UpdateLogDetailMapper;
import com.besscroft.aurora.mall.admin.mapper.UpdateLogMapper;
import com.besscroft.aurora.mall.admin.service.UpdateLogService;
import com.besscroft.aurora.mall.common.entity.UpdateLog;
import com.besscroft.aurora.mall.common.entity.UpdateLogDetail;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Bess Croft
 * @Date 2021/4/17 21:33
 */
@Service
@RequiredArgsConstructor
public class UpdateLogServiceImpl extends ServiceImpl<UpdateLogMapper, UpdateLog> implements UpdateLogService {

    private final UpdateLogDetailMapper updateLogDetailMapper;

    @Override
    public List<UpdateLog> getUpdateLogList() {
        List<UpdateLog> updateLogs = this.baseMapper.selectAllList();
        updateLogs.forEach(updateLog -> {
            QueryWrapper<UpdateLogDetail> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("log_id", updateLog.getId());
            List<UpdateLogDetail> updateLogDetails = updateLogDetailMapper.selectList(queryWrapper);
            updateLog.setDetail(updateLogDetails);
        });
        return updateLogs;
    }

}
