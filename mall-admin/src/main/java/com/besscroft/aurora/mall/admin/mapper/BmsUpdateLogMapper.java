package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.BmsUpdateLog;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/17 21:36
 */
public interface BmsUpdateLogMapper extends BaseMapper<BmsUpdateLog> {

    /**
     * 查询版本日志列表
     * @return
     */
    List<BmsUpdateLog>  selectAllList();

}
