package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.model.RoleResourceRelation;

import java.util.List;

/**
 * 权限管理模块角色和资源持久化
 *
 * @Author Bess Croft
 * @Date 2021/3/17 16:18
 */
public interface RoleResourceRelationMapper extends BaseMapper<RoleResourceRelation> {

    /**
     * 查询所有角色和资源的对应关系
     * @return 所有角色和资源对应关系集合
     */
    List<RoleResourceRelation> selectAll();

}
