package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.AuthRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限管理模块角色持久化
 *
 * @Author Besscroft
 * @Date 2021/2/18 11:08
 */
public interface AuthRoleMapper extends BaseMapper<AuthRole> {

    /**
     * 获取所有角色
     * @return 所有角色集合
     */
    List<AuthRole> selectAll();

    /**
     * 根据adminId获取用户所有的角色
     * @param adminId 用户id
     * @return 用户的角色集合
     */
    List<AuthRole> selectAuthRoleListByAdminId(@Param("adminId") Long adminId);

    /**
     * 查询角色列表
     * @param keyword 关键字
     * @return 分页角色列表
     */
    List<AuthRole> selectRoleListByPage(String keyword);

    /**
     * 根据id查询角色详细信息
     * @param id 角色id
     * @return
     */
    AuthRole selectRoleById(Long id);

    /**
     * 插入一条新角色数据
     * @param authRole 角色实体
     * @return
     */
    int insertRole(AuthRole authRole);

    /**
     * 更新角色数据
     * @param authRole 角色实体
     * @return
     */
    int updateRole(AuthRole authRole);

    /**
     * 根据id删除角色（假删除）
     * @param id 角色id
     * @return
     */
    int deleteRoleById(Long id);

    /**
     * 角色可用状态变更
     * @param status 可用状态
     * @param id 角色id
     * @return
     */
    int changeSwitch(@Param("status") Integer status,
                     @Param("id") Long id);

    /**
     * 根据用户id删除用户和角色对应关系
     * @param userId 用户id
     * @return
     */
    int deleteUserRoleRelationById(Long userId);

    /**
     * 更新用户和角色对应关系
     * @param userId 用户id
     * @param roleId 角色id
     * @return
     */
    int insertUserRoleRelation(@Param("userId") Long userId,
                       @Param("roleId") Long roleId);

}
