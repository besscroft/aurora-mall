package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.AuthResourceSortMapper;
import com.besscroft.aurora.mall.admin.service.ResourceSortService;
import com.besscroft.aurora.mall.common.entity.AuthResourceSort;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/17 19:04
 */
@Service
public class ResourceSortServiceImpl implements ResourceSortService {

    @Autowired
    private AuthResourceSortMapper authResourceSortMapper;

    @Override
    public List<AuthResourceSort> getResourcePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return authResourceSortMapper.selectResourceSortListByPage(keyword);
    }

    @Override
    public AuthResourceSort getResourceSortById(Long id) {
        return authResourceSortMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addResourceSort(AuthResourceSort authResourceSort) {
        authResourceSort.setCreateTime(LocalDateTime.now());
        return authResourceSortMapper.addResourceSort(authResourceSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateResourceSort(AuthResourceSort authResourceSort) {
        authResourceSort.setCreateTime(LocalDateTime.now());
        return authResourceSortMapper.updateResourceSort(authResourceSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delResourceSort(List<Long> ids) {
        return authResourceSortMapper.deleteBatchIds(ids) > 0;
    }

}
