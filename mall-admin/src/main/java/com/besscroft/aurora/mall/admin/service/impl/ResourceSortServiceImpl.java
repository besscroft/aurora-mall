package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.AuthResourceSortMapper;
import com.besscroft.aurora.mall.admin.service.ResourceSortService;
import com.besscroft.aurora.mall.common.entity.AuthResourceSort;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Bess Croft
 * @Date 2021/4/17 19:04
 */
@Service
public class ResourceSortServiceImpl extends ServiceImpl<AuthResourceSortMapper, AuthResourceSort> implements ResourceSortService {

    @Override
    public List<AuthResourceSort> getResourcePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectResourceSortListByPage(keyword);
    }

    @Override
    public AuthResourceSort getResourceSortById(Long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addResourceSort(AuthResourceSort authResourceSort) {
        authResourceSort.setCreateTime(LocalDateTime.now());
        return this.baseMapper.addResourceSort(authResourceSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateResourceSort(AuthResourceSort authResourceSort) {
        authResourceSort.setCreateTime(LocalDateTime.now());
        return this.baseMapper.updateResourceSort(authResourceSort) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delResourceSort(List<Long> ids) {
        return this.baseMapper.deleteBatchIds(ids) > 0;
    }

}
