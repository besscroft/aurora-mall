package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.BmsAuthResourceSortMapper;
import com.besscroft.aurora.mall.admin.service.ResourceSortService;
import com.besscroft.aurora.mall.common.entity.BmsAuthResourceSort;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/17 19:04
 */
@Service
public class ResourceSortServiceImpl implements ResourceSortService {

    @Autowired
    private BmsAuthResourceSortMapper bmsAuthResourceSortMapper;

    @Override
    public List<BmsAuthResourceSort> getResourcePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<BmsAuthResourceSort> resources = bmsAuthResourceSortMapper.selectResourceSortListByPage(keyword);
        return resources;
    }

    @Override
    public BmsAuthResourceSort getResourceSortById(Long id) {
        return bmsAuthResourceSortMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addResourceSort(BmsAuthResourceSort bmsAuthResourceSort) {
        bmsAuthResourceSort.setCreateTime(new Date());
        return bmsAuthResourceSortMapper.addResourceSort(bmsAuthResourceSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateResourceSort(BmsAuthResourceSort bmsAuthResourceSort) {
        bmsAuthResourceSort.setCreateTime(new Date());
        return bmsAuthResourceSortMapper.updateResourceSort(bmsAuthResourceSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delResourceSort(Long id) {
        return bmsAuthResourceSortMapper.deleteById(id) > 0;
    }

}
