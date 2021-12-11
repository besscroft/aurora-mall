package com.besscroft.aurora.mall.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.besscroft.aurora.mall.admin.domain.dto.UserInfoDetailDto;
import com.besscroft.aurora.mall.common.entity.UserInfo;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/12/7 21:29
 */
public interface MallUserService extends IService<UserInfo> {

    /**
     * 获取用户列表
     * @param pageNum 页码
     * @param pageSize 页大小
     * @return
     */
    List<UserInfo> getUserList(Integer pageNum, Integer pageSize);

    /**
     * 查询用户的详情信息
     * @param userId 用户id
     * @return
     */
    UserInfoDetailDto getUserDetail(String userId);

}
