package com.besscroft.aurora.mall.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.besscroft.aurora.mall.common.entity.BmsAuthUser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

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
     * 分页查询管理系统用户列表
     * @param keyword
     * @return
     */
    List<BmsAuthUser> selectUserListByPage(String keyword);

    /**
     * 登录成功后设置登录时间
     * @param loginTime
     * @return
     */
    int updateLoginTime(@Param("loginTime") Date loginTime,
                        @Param("id") Long id);

    /**
     * 更新用户数据
     * @param bmsAuthUser
     * @return
     */
    int updateUser(BmsAuthUser bmsAuthUser);

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
     * @param bmsAuthUser
     * @return
     */
    int insertUser(BmsAuthUser bmsAuthUser);

    /**
     * 获取所有用户
     * @return
     */
    List<BmsAuthUser> getAllList();

}
