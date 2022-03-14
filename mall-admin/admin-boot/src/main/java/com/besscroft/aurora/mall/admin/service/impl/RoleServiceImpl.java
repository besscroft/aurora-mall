package com.besscroft.aurora.mall.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.AuthRoleMapper;
import com.besscroft.aurora.mall.admin.service.RoleService;
import com.besscroft.aurora.mall.common.entity.AuthRole;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author Bess Croft
 * @Date 2021/4/10 9:42
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl extends ServiceImpl<AuthRoleMapper, AuthRole> implements RoleService {

    private final ResourceServiceImpl resourceServiceImpl;

    @Override
    public List<AuthRole> getRolePageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectRoleListByPage(keyword);
    }

    @Override
    public AuthRole getRoleById(Long id) {
        return this.baseMapper.selectRoleById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addRole(AuthRole authRole) {
        authRole.setCreateTime(LocalDateTime.now());
        authRole.setDel(1);
        int i = this.baseMapper.insertRole(authRole);
        if (i>0) {
            // 更新角色与资源的对应关系
            resourceServiceImpl.initRoleResourceMap();
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRole(AuthRole authRole) {
        int i = this.baseMapper.updateRole(authRole);
        if (i>0) {
            // 更新角色与资源的对应关系
            resourceServiceImpl.initRoleResourceMap();
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delRoleById(List<Long> ids) {
        int i = this.baseMapper.deleteRoleById(ids);
        if (i>0) {
            // 更新角色与资源的对应关系
            resourceServiceImpl.initRoleResourceMap();
            return true;
        }
        return false;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitch(boolean status, Long id) {
        if (status) {
            return this.baseMapper.changeSwitch(1, id) > 0;
        }
        return this.baseMapper.changeSwitch(0, id) > 0;
    }

    @Override
    public List<AuthRole> getRoleAll() {
        return this.baseMapper.selectAll();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateRoleById(Long userId, Long roleId) {
        // 先删除原有的
        int i = this.baseMapper.deleteUserRoleRelationById(userId);
        if (i > 0) {
            return this.baseMapper.insertUserRoleRelation(userId, roleId) > 0;
        }
        return false;
    }

}
