package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.domain.param.ResourceParam;
import com.besscroft.aurora.mall.admin.mapper.AuthResourceMapper;
import com.besscroft.aurora.mall.admin.mapper.AuthResourceSortMapper;
import com.besscroft.aurora.mall.admin.mapper.AuthRoleMapper;
import com.besscroft.aurora.mall.admin.mapper.RoleResourceRelationMapper;
import com.besscroft.aurora.mall.admin.service.ResourceService;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.constant.SystemConstants;
import com.besscroft.aurora.mall.common.entity.AuthResource;
import com.besscroft.aurora.mall.common.entity.AuthResourceSort;
import com.besscroft.aurora.mall.common.entity.AuthRole;
import com.besscroft.aurora.mall.common.exception.NotPermissionException;
import com.besscroft.aurora.mall.common.model.RoleResourceRelation;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Bess Croft
 * @Date 2021/3/17 15:49
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ResourceServiceImpl extends ServiceImpl<AuthResourceMapper, AuthResource> implements ResourceService {

    @Value("${spring.profiles.active}")
    private String env;

    @Value("${spring.application.name}")
    private String applicationName;

    private final AuthRoleMapper authRoleMapper;
    private final RoleResourceRelationMapper roleResourceRelationMapper;
    private final AuthResourceSortMapper authResourceSortMapper;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    public Map<String, List<String>> initRoleResourceMap() {
        Map<String,List<String>> RoleResourceMap = new TreeMap<>();
        List<AuthResource> authResourceList = this.baseMapper.selectAll();
        List<AuthRole> authRoleList = authRoleMapper.selectAll();
        List<RoleResourceRelation> roleResourceRelationList = roleResourceRelationMapper.selectAll();
        for (AuthResource resource: authResourceList) {
            Set<Long> roleIds = roleResourceRelationList.stream().filter(item ->
                    item.getResourceId().equals(resource.getId())
            ).map(RoleResourceRelation::getRoleId)
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
    public List<AuthResource> getResourcePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectResourceListByPage(keyword);
    }

    @Override
    public AuthResource getResourceById(Long id) {
        return this.baseMapper.selectById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addResource(AuthResource authResource) {
        authResource.setCreateTime(LocalDateTime.now());
        return this.baseMapper.insertResource(authResource) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateResource(AuthResource authResource) {
        return this.baseMapper.updateResource(authResource) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delResource(List<Long> ids) {
        this.baseMapper.deleteBatchIds(ids);
        return true;
    }

    @Override
    public List<ResourceParam> getAllResourceTree() {
        List<ResourceParam> list = new ArrayList<>();
        List<AuthResourceSort> resourceSorts = authResourceSortMapper.selectList(new QueryWrapper<>());
        resourceSorts.forEach(r -> {
            ResourceParam resourceParam = new ResourceParam();
            QueryWrapper<AuthResource> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("category_id",r.getId());
            List<AuthResource> resources = this.baseMapper.selectList(queryWrapper);
            resourceParam.setName(r.getCategoryName());
            resourceParam.setDisabled(true);
            resourceParam.setChildren(resources);
            list.add(resourceParam);
        });
        return list;
    }

    @Override
    public List<Long> getResourceTreeById(Long id) {
        return this.baseMapper.selectResourceTreeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateResourceTree(List<Long> resourceIds, Long id) {
        if (Objects.equals(id, 1L) && SystemConstants.SYSTEM_PROD_ENV.equals(env)) {
            // 超级管理员，默认拥有所有权限，不允许更改！(给演示环境做的保护)
            throw new NotPermissionException("演示环境不允许更改超级管理员的权限！");
        }
        int i = this.baseMapper.deleteRoleResourceRelation(id);
        if (i > 0) {
            int relation = this.baseMapper.insertRoleResourceRelation(resourceIds, id);
            initRoleResourceMap();
            return relation > 0;
        }
        return false;
    }

}
