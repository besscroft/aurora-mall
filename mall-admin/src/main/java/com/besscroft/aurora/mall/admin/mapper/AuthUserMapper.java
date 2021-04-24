package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 权限管理模块用户Mapper接口
 *
 * @Author Besscroft
 * @Date 2021/2/18 10:49
 */
public interface AuthUserMapper extends BaseMapper<AuthUser> {

    /**
     * 查询管理系统用户
     *
     * @param username 用户名
     * @return 管理系统用户
     */
    AuthUser selectAuthUserByUsername(@Param("username") String username);

    /**
     * 分页查询管理系统用户列表
     * @param keyword
     * @return
     */
    List<AuthUser> selectUserListByPage(String keyword);

    /**
     * 登录成功后设置登录时间
     * @param loginTime
     * @return
     */
    int updateLoginTime(@Param("loginTime") Date loginTime,
                        @Param("id") Long id);

    /**
     * 更新用户数据
     * @param authUser
     * @return
     */
    int updateUser(AuthUser authUser);

    /**
     * 更新用户账户的可用状态
     * @param status
     * @param id
     * @return
     */
    int changeSwitch(@Param("status") Integer status,
                     @Param("id") Long id);

    /**
     * 删除用户（假删除）
     * @param id
     * @return
     */
    int delUser(Long id);

    /**
     * 新增用户
     * @param authUser
     * @return
     */
    int insertUser(AuthUser authUser);

    /**
     * 获取所有用户
     * @return
     */
    List<AuthUser> getAllList();

}
