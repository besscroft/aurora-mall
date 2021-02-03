package com.besscroft.aurora.mall.auth.mapper;

import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 后台用户登录mapper
 *
 * @Author Besscroft
 * @Date 2021/1/23 12:58
 */
public interface BmsAuthUserMapper {

    /**
     * 根据username获取管理系统用户信息
     */
    BmsAuthUser selectBmsAuthUserByUsername(@Param("username") String username);

}
