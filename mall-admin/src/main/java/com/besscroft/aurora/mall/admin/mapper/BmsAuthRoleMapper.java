package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.BmsAuthRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 权限管理模块角色Mapper接口
 *
 * @Author Besscroft
 * @Date 2021/2/18 11:08
 */
public interface BmsAuthRoleMapper extends BaseMapper<BmsAuthRole> {

    /**
     * 获取所有角色
     * @return
     */
    List<BmsAuthRole> selectAll();

    /**
     * 根据adminId获取用户所有的角色
     * @param adminId
     * @return
     */
    List<BmsAuthRole> selectBmsAuthRoleListByAdminId(@Param("adminId") Long adminId);

    /**
     * 查询角色列表
     * @param keyword
     * @return
     */
    List<BmsAuthRole> selectRoleListByPage(String keyword);

    /**
     * 根据id查询角色详细信息
     * @param id
     * @return
     */
    BmsAuthRole selectRoleById(Long id);

    /**
     * 插入一条新角色数据
     * @param bmsAuthRole
     * @return
     */
    int insertRole(BmsAuthRole bmsAuthRole);

    /**
     * 更新角色数据
     * @param bmsAuthRole
     * @return
     */
    int updateRole(BmsAuthRole bmsAuthRole);

    /**
     * 根据id删除角色（假删除）
     * @param id
     * @return
     */
    int deleteRoleById(Long id);

    /**
     * 角色可用状态变更
     * @param status
     * @param id
     * @return
     */
    int changeSwitch(@Param("status") Integer status,
                     @Param("id") Long id);

    /**
     * 根据用户id删除用户和角色对应关系
     * @param userId
     * @return
     */
    int deleteUserRoleRelationById(Long userId);

    /**
     * 更新用户和角色对应关系
     * @param userId
     * @param roleId
     * @return
     */
    int insertUserRoleRelation(@Param("userId") Long userId,
                       @Param("roleId") Long roleId);

}
