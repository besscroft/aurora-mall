package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.admin.dto.BmsAdminInfoParam;
import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import org.apache.ibatis.annotations.Param;

/**
 * 权限管理模块用户Mapper接口
 *
 * @Author Besscroft
 * @Date 2021/2/18 10:49
 */
public interface BmsAuthUserMapper extends BaseMapper<BmsAuthUser> {

    /**
     * 查询管理系统用户
     *
     * @param username 用户名
     * @return 管理系统用户
     */
    BmsAuthUser selectBmsAuthUserByUsername(@Param("username") String username);

    /**
     * 获取当前登录用户的一些信息
     * @return
     */
    BmsAdminInfoParam getInfo(Long id);

}
