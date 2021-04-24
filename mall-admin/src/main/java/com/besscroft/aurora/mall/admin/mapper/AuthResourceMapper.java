package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.AuthResource;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限管理模块资源Mapper接口
 *
 * @Author Besscroft
 * @Date 2021/3/17 15:51
 */
public interface AuthResourceMapper extends BaseMapper<AuthResource> {

    /**
     * 查询所有资源
     * @return
     */
    List<AuthResource> selectAll();

    /**
     * 分页查询资源列表
     * @param keyword
     * @return
     */
    List<AuthResource> selectResourceListByPage(String keyword);

    /**
     * 新增资源
     * @param authResource
     * @return
     */
    int insertResource(AuthResource authResource);

    /**
     * 更新资源
     * @param authResource
     * @return
     */
    int updateResource(AuthResource authResource);

    /**
     * 根据角色id获取资源树数组
     * @param id
     * @return
     */
    List<Long> selectResourceTreeById(Long id);

    /**
     * 根据角色id删除角色资源关系
     * @param id
     * @return
     */
    int deleteRoleResourceRelation(Long id);

    int insertRoleResourceRelation(@Param("resourceId") Long resourceId,
                                   @Param("roleId") Long roleId);

}
