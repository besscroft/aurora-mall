package com.besscroft.aurora.mall.log.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.common.entity.WebLog;
import com.besscroft.aurora.mall.log.mapper.LogMapper;
import com.besscroft.aurora.mall.log.service.LogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Bess Croft
 * @Time 2021/7/18 17:55
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, WebLog> implements LogService {

    @Override
    @Transactional
    public boolean saveWebLog(WebLog webLog) {
        return this.baseMapper.insert(webLog) > 0;
    }

    @Override
    public List<WebLog> pageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectListByDescription(keyword);
    }
}
