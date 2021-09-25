package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.AuthResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限管理模块资源持久化
 *
 * @Author Bess Croft
 * @Date 2021/3/17 15:51
 */
public interface AuthResourceMapper extends BaseMapper<AuthResource> {

    /**
     * 查询所有资源
     * @return 所有资源
     */
    List<AuthResource> selectAll();

    /**
     * 分页查询资源列表
     * @param keyword 关键字
     * @return 分页资源列表
     */
    List<AuthResource> selectResourceListByPage(String keyword);

    /**
     * 新增资源
     * @param authResource 资源实体
     * @return
     */
    int insertResource(AuthResource authResource);

    /**
     * 更新资源
     * @param authResource 资源实体
     * @return
     */
    int updateResource(AuthResource authResource);

    /**
     * 根据角色id获取资源树数组
     * @param id 角色id
     * @return 角色的资源树数组
     */
    List<Long> selectResourceTreeById(Long id);

    /**
     * 根据角色id删除角色资源关系
     * @param id 角色id
     * @return
     */
    int deleteRoleResourceRelation(Long id);

    /**
     * 插入角色和资源对应关系
     * @param resourceIds 资源id集合
     * @param roleId 角色id
     * @return
     */
    int insertRoleResourceRelation(@Param("resourceIds") List<Long> resourceIds,
                                   @Param("roleId") Long roleId);

}
