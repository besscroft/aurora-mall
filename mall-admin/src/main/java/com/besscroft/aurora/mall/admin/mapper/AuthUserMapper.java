package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * 权限管理模块用户持久化
 *
 * @Author Besscroft
 * @Date 2021/2/18 10:49
 */
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    /**
     * 查询管理系统用户
     *
     * @param username 用户名
     * @return 用户实体
     */
    AuthUser selectAuthUserByUsername(@Param("username") String username);

    /**
     * 分页查询管理系统用户列表
     * @param keyword 关键字
     * @return 分页用户列表
     */
    List<AuthUser> selectUserListByPage(String keyword);

    /**
     * 登录成功后设置登录时间
     * @param loginTime 登录时间
     * @param id 用户id
     * @return
     */
    int updateLoginTime(@Param("loginTime")LocalDate loginTime,
                        @Param("id") Long id);

    /**
     * 更新用户数据
     * @param authUser 用户实体
     * @return
     */
    int updateUser(AuthUser authUser);

    /**
     * 更新用户账户的可用状态
     * @param status 可以状态
     * @param id 用户id
     * @return
     */
    int changeSwitch(@Param("status") Integer status,
                     @Param("id") Long id);

    /**
     * 删除用户（假删除）
     * @param id 用户id
     * @return
     */
    int delUser(Long id);

    /**
     * 新增用户
     * @param authUser 用户实体
     * @return
     */
    int insertUser(AuthUser authUser);

    /**
     * 获取所有用户
     * @return 所有用户集合
     */
    List<AuthUser> getAllList();

}
