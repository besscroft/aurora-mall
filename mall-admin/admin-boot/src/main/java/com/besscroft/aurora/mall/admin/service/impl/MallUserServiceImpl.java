package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.MallUserMapper;
import com.besscroft.aurora.mall.admin.service.MallUserService;
import com.besscroft.aurora.mall.common.entity.UserInfo;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/12/7 21:30
 */
@Slf4j
@Service
public class MallUserServiceImpl extends ServiceImpl<MallUserMapper, UserInfo> implements MallUserService {

    @Override
    public List<UserInfo> getUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectUserList();
    }

}
