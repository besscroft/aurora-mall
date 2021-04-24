package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.model.RoleResourceRelation;

import java.util.List;

/**
 * 权限管理模块角色和资源Mapper接口
 *
 * @Author Besscroft
 * @Date 2021/3/17 16:18
 */
public interface RoleResourceRelationMapper extends BaseMapper<RoleResourceRelation> {

    /**
     * 查询所有角色和资源的对应关系
     * @return
     */
    List<RoleResourceRelation> selectAll();

}
