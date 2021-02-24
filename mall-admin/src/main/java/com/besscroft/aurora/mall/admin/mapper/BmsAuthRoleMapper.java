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
     * 获取管理系统用户所有的角色
     * @param adminId
     * @return
     */
    List<BmsAuthRole> selectBmsAuthRoleListByAdminId(@Param("adminId") Long adminId);

}
