package com.besscroft.aurora.mall.log.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.WebLog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author Bess Croft
 * @Time 2021/7/18 17:57
 */
public interface LogMapper extends BaseMapper<WebLog> {

    /**
     * 查询所有的访问日志
     * @param description 日志描述信息
     * @return
     */
    List<WebLog> selectListByDescription(@Param("description") String description);

}
