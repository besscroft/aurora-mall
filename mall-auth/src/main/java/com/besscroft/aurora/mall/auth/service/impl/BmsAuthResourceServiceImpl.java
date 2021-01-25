package com.besscroft.aurora.mall.auth.service.impl;

import com.besscroft.aurora.mall.auth.mapper.BmsAuthResourceMapper;
import com.besscroft.aurora.mall.auth.service.BmsAuthResourceService;
import com.besscroft.aurora.mall.common.entity.BmsAuthResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/1/23 17:13
 */
@Service
public class BmsAuthResourceServiceImpl implements BmsAuthResourceService {

    @Autowired
    private BmsAuthResourceMapper bmsAuthResourceMapper;

    @Override
    public List<BmsAuthResource> getResourceList(Long id) {
        List<BmsAuthResource> bmsAuthResources = bmsAuthResourceMapper.selectBmsAuthResourceListById(id);
        return bmsAuthResources;
    }

}
