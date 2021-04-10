package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.BmsAuthRoleMapper;
import com.besscroft.aurora.mall.admin.service.RoleService;
import com.besscroft.aurora.mall.common.entity.BmsAuthRole;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/4/10 9:42
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private BmsAuthRoleMapper bmsAuthRoleMapper;

    @Override
    public List<BmsAuthRole> getRolePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        List<BmsAuthRole> roles = bmsAuthRoleMapper.selectRoleListByPage(keyword);
        return roles;
    }

    @Override
    public BmsAuthRole getRoleById(Long id) {
        return bmsAuthRoleMapper.selectRoleById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRole(BmsAuthRole bmsAuthRole) {
        bmsAuthRole.setCreateTime(new Date());
        return bmsAuthRoleMapper.insertRole(bmsAuthRole) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRole(BmsAuthRole bmsAuthRole) {
        return bmsAuthRoleMapper.updateRole(bmsAuthRole) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delRoleById(Long id) {
        return bmsAuthRoleMapper.deleteRoleById(id) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitch(boolean status, Long id) {
        if (status) {
            return bmsAuthRoleMapper.changeSwitch(1, id) > 0;
        }
        return bmsAuthRoleMapper.changeSwitch(0, id) > 0;
    }

}
