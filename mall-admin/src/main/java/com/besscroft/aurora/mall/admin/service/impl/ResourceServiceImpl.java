package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.besscroft.aurora.mall.admin.dto.BmsResourceParam;
import com.besscroft.aurora.mall.admin.mapper.BmsAuthResourceMapper;
import com.besscroft.aurora.mall.admin.mapper.BmsAuthResourceSortMapper;
import com.besscroft.aurora.mall.admin.mapper.BmsAuthRoleMapper;
import com.besscroft.aurora.mall.admin.mapper.BmsRoleResourceRelationMapper;
import com.besscroft.aurora.mall.admin.service.ResourceService;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.entity.BmsAuthResource;
import com.besscroft.aurora.mall.common.entity.BmsAuthResourceSort;
import com.besscroft.aurora.mall.common.entity.BmsAuthRole;
import com.besscroft.aurora.mall.common.model.BmsRoleResourceRelation;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Besscroft
 * @Date 2021/3/17 15:49
 */
@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private BmsAuthResourceMapper bmsAuthResourceMapper;

    @Autowired
    private BmsAuthRoleMapper bmsAuthRoleMapper;

    @Autowired
    private BmsRoleResourceRelationMapper bmsRoleResourceRelationMapper;

    @Autowired
    private BmsAuthResourceSortMapper bmsAuthResourceSortMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Value("${spring.application.name}")
    private String applicationName;

    @Override
    public Map<String, List<String>> initRoleResourceMap() {
        Map<String,List<String>> RoleResourceMap = new TreeMap<>();
        List<BmsAuthResource> authResourceList = bmsAuthResourceMapper.selectAll();
        List<BmsAuthRole> authRoleList = bmsAuthRoleMapper.selectAll();
        List<BmsRoleResourceRelation> roleResourceRelationList = bmsRoleResourceRelationMapper.selectAll();
        for (BmsAuthResource resource: authResourceList) {
            Set<Long> roleIds = roleResourceRelationList.stream().filter(item ->
                    item.getResourceId().equals(resource.getId())
            ).map(BmsRoleResourceRelation::getRoleId)
                    .collect(Collectors.toSet());
            List<String> roleNames = authRoleList.stream().filter(item ->
                    roleIds.contains(item.getId())
            ).map(item ->
                    // 格式:ROLE_{roleId}
                    AuthConstants.AUTHORITY_PREFIX + item.getId() + "_" + item.getName()
            ).collect(Collectors.toList());
            // key为访问路径/资源路径，value为角色
            RoleResourceMap.put("/" + applicationName + resource.getUrl(), roleNames);
        }
        redisTemplate.delete(AuthConstants.PERMISSION_RULES_KEY);
        redisTemplate.opsForHash().putAll(AuthConstants.PERMISSION_RULES_KEY, RoleResourceMap);
        return RoleResourceMap;
    }

    @Override
    public List<BmsAuthResource> getResourcePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<BmsAuthResource> resources = bmsAuthResourceMapper.selectResourceListByPage(keyword);
        return resources;
    }

    @Override
    public BmsAuthResource getResourceById(Long id) {
        return bmsAuthResourceMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addResource(BmsAuthResource bmsAuthResource) {
        bmsAuthResource.setCreateTime(new Date());
        return bmsAuthResourceMapper.insertResource(bmsAuthResource) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateResource(BmsAuthResource bmsAuthResource) {
        return bmsAuthResourceMapper.updateResource(bmsAuthResource) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delResource(Long id) {
        return bmsAuthResourceMapper.deleteById(id) > 0;
    }

    @Override
    public List<BmsResourceParam> getAllResourceTree() {
        List<BmsResourceParam> list = new ArrayList<>();
        List<BmsAuthResourceSort> resourceSorts = bmsAuthResourceSortMapper.selectList(new QueryWrapper<>());
        resourceSorts.forEach(r -> {
            BmsResourceParam bmsResourceParam = new BmsResourceParam();
            QueryWrapper<BmsAuthResource> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("category_id",r.getId());
            List<BmsAuthResource> resources = bmsAuthResourceMapper.selectList(queryWrapper);
            bmsResourceParam.setName(r.getCategoryName());
            bmsResourceParam.setDisabled(true);
            bmsResourceParam.setChildren(resources);
            list.add(bmsResourceParam);
        });
        return list;
    }

    @Override
    public List<Long> getResourceTreeById(Long id) {
        List<Long> longs = bmsAuthResourceMapper.selectResourceTreeById(id);
        return longs;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateResourceTree(List<Long> data, Long id) {
        bmsAuthResourceMapper.deleteRoleResourceRelation(id);
        data.forEach(d -> {
            bmsAuthResourceMapper.insertRoleResourceRelation(d, id);
        });
        return true;
    }

}
