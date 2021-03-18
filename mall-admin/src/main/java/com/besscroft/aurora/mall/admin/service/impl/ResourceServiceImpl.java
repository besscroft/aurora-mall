package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.BmsAuthResourceMapper;
import com.besscroft.aurora.mall.admin.mapper.BmsAuthRoleMapper;
import com.besscroft.aurora.mall.admin.mapper.BmsRoleResourceRelationMapper;
import com.besscroft.aurora.mall.admin.service.ResourceService;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.entity.BmsAuthResource;
import com.besscroft.aurora.mall.common.entity.BmsAuthRole;
import com.besscroft.aurora.mall.common.model.BmsRoleResourceRelation;
import com.besscroft.aurora.mall.common.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
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
    private RedisService redisService;

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
//                    item.getId() + "_" + item.getName()
                            item.getName()
            ).collect(Collectors.toList());
            // key为访问路径/资源路径，value为角色
            RoleResourceMap.put("/" + applicationName + resource.getUrl(), roleNames);
        }
        redisService.del(AuthConstants.PERMISSION_RULES_KEY);
        redisService.hSetAll(AuthConstants.PERMISSION_RULES_KEY, RoleResourceMap);
        return RoleResourceMap;
    }

}
