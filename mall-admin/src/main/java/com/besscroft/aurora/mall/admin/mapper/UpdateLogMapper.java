package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.UpdateLog;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/17 21:36
 */
public interface UpdateLogMapper extends BaseMapper<UpdateLog> {

    /**
     * 查询版本日志列表
     * @return
     */
    List<UpdateLog>  selectAllList();

}
