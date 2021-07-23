package com.besscroft.aurora.mall.admin.service.impl;

import com.besscroft.aurora.mall.admin.mapper.AuthRoleMapper;
import com.besscroft.aurora.mall.admin.service.RoleService;
import com.besscroft.aurora.mall.common.entity.AuthRole;
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
    private AuthRoleMapper authRoleMapper;

    @Override
    public List<AuthRole> getRolePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return authRoleMapper.selectRoleListByPage(keyword);
    }

    @Override
    public AuthRole getRoleById(Long id) {
        return authRoleMapper.selectRoleById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRole(AuthRole authRole) {
        authRole.setCreateTime(new Date());
        authRole.setDel(1);
        return authRoleMapper.insertRole(authRole) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRole(AuthRole authRole) {
        return authRoleMapper.updateRole(authRole) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delRoleById(List<Long> ids) {
        return authRoleMapper.deleteRoleById(ids) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitch(boolean status, Long id) {
        if (status) {
            return authRoleMapper.changeSwitch(1, id) > 0;
        }
        return authRoleMapper.changeSwitch(0, id) > 0;
    }

    @Override
    public List<AuthRole> getRoleAll() {
        return authRoleMapper.selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRoleById(Long userId, Long roleId) {
        // 先删除原有的
        int i = authRoleMapper.deleteUserRoleRelationById(userId);
        if (i > 0) {
            return authRoleMapper.insertUserRoleRelation(userId, roleId) > 0;
        }
        return false;
    }

}
