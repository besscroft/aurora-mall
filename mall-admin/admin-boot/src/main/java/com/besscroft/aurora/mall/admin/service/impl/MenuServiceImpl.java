package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.AuthMenuMapper;
import com.besscroft.aurora.mall.admin.service.MenuService;
import com.besscroft.aurora.mall.admin.service.UserService;
import com.besscroft.aurora.mall.common.entity.AuthMenu;
import com.besscroft.aurora.mall.common.entity.AuthUser;
import com.besscroft.aurora.mall.common.exception.NotPermissionException;
import com.besscroft.aurora.mall.common.model.MetaVo;
import com.besscroft.aurora.mall.common.model.RouterVo;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

/**
 * @Author Bess Croft
 * @Date 2021/3/21 19:15
 */
@Service
public class MenuServiceImpl extends ServiceImpl<AuthMenuMapper, AuthMenu> implements MenuService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    private UserService userService;

    @Override
    public Map<String, Object> getTreeListById(Long adminId) {
        Map<String, Object> data = (Map<String, Object>) redisTemplate.boundHashOps("admin").get("user:tree:" + adminId);
        if (CollUtil.isEmpty(data)) {
            synchronized (this) {
                data = (Map<String, Object>) redisTemplate.boundHashOps("admin").get("user:tree:" + adminId);
                if (CollUtil.isEmpty(data)) {
                    List<AuthMenu> menuList = this.baseMapper.getParentListById(adminId);
                    menuList.forEach(menu -> {
                        List<AuthMenu> childListById = this.baseMapper.getChildListById(adminId, menu.getId());
                        menu.setChildren(childListById);
                    });
                    List<RouterVo> routerVoList = new LinkedList<>();
                    menuList.forEach(menu -> {
                        RouterVo routerVo = new RouterVo();
                        routerVo.setName(menu.getName());
                        routerVo.setPath(menu.getPath());
                        routerVo.setHidden(menu.getHidden() != 0);
                        routerVo.setComponent(menu.getComponent());
                        routerVo.setMeta(new MetaVo(menu.getTitle(), menu.getIcon(), false));
                        List<RouterVo> list = new ArrayList<>();
                        if (menu.getChildren().size() > 0 && !menu.getChildren().isEmpty()) {
                            routerVo.setAlwaysShow(true);
                            routerVo.setRedirect("noRedirect");
                            menu.getChildren().forEach(child -> {
                                RouterVo router = new RouterVo();
                                router.setPath(child.getPath());
                                router.setName(child.getName());
                                router.setComponent(child.getComponent());
                                router.setMeta(new MetaVo(child.getTitle(), child.getIcon(), false));
                                router.setHidden(child.getHidden() != 0);
                                list.add(router);
                            });
                            routerVo.setChildren(list);
                        }
                        routerVoList.add(routerVo);
                    });
                    data = new HashMap<>();
                    data.put("menus", routerVoList);
//                    redisTemplate.boundHashOps("admin").delete("user:tree:" + adminId);
                    redisTemplate.boundHashOps("admin").put("user:tree:" + adminId, data);
                }
            }
        }
        return data;
    }

    @Override
    public List<AuthMenu> getMenuListById(Long adminId) {
        List<AuthMenu> menuList = (List<AuthMenu>) redisTemplate.opsForValue().get("admin:menu:user:" + adminId);
        if (CollUtil.isEmpty(menuList)) {
            synchronized (this) {
                menuList = (List<AuthMenu>) redisTemplate.opsForValue().get("admin:menu:user:" + adminId);
                if (CollUtil.isEmpty(menuList)) {
                    menuList = this.baseMapper.getParentListById(adminId);
                    menuList.forEach(menu -> {
                        List<AuthMenu> childListById = this.baseMapper.getChildListById(adminId, menu.getId());
                        menu.setChildren(childListById);
                    });
//                    redisTemplate.delete("admin:menu:user:" + adminId);
                    redisTemplate.opsForValue().set("admin:menu:user:" + adminId, menuList);
                }
            }
        }
        return menuList;
    }

    @Override
    public List<AuthMenu> getMenuAllList() {
        return this.baseMapper.selectList(new QueryWrapper<AuthMenu>());
    }

    @Override
    public List<AuthMenu> getParentMenu() {
        return this.baseMapper.getParentMenu();
    }

    @Override
    public List<AuthMenu> getMenuPageList(Integer pageNum, Integer pageSize, String keyword) {
        PageHelper.startPage(pageNum, pageSize);
        return this.baseMapper.selectMenuListByPage(keyword);
    }

    @Override
    public AuthMenu getMenuById(Long id) {
        return this.baseMapper.selectMenuById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateMenu(AuthMenu authMenu) {
        return this.baseMapper.updateMenu(authMenu) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean changeSwitch(boolean hidden, Long id, Long adminId) {
        if (hidden) {
            int i = this.baseMapper.changeSwitch(1, id);
            if (i>0) {
                redisTemplate.boundHashOps("admin").delete("user:tree:" + adminId);
                return true;
            }
        }
        return this.baseMapper.changeSwitch(0, id) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delMenu(List<Long> ids) {
        return this.baseMapper.deleteBatchIds(ids) > 0;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean addMenu(AuthMenu authMenu) {
        authMenu.setCreateTime(LocalDateTime.now());
        return this.baseMapper.addMenu(authMenu) > 0;
    }

    @Override
    public List<Long> getMenuTreeById(Long id) {
        return this.baseMapper.selectMenuTreeById(id);
    }

    @Override
    public List<AuthMenu> getAllMenuTree() {
        List<AuthMenu> parentMenu = this.baseMapper.getParentMenu();
        parentMenu.forEach(menu -> {
            List<AuthMenu> childList = this.baseMapper.getChildList(menu.getId());
            menu.setChildren(childList);
        });
        return parentMenu;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean updateMenuTree(List<Long> menuIds, Long id) {
        if (Objects.equals(id, 1L)) {
            // 超级管理员，默认拥有所有菜单，不允许更改！(给演示环境做的保护)
            throw new NotPermissionException("演示环境不允许更改超级管理员的菜单！");
        }
        int i = this.baseMapper.deleteRoleMenuRelation(id);
        if (i > 0) {
            int j = this.baseMapper.insertRoleMenuRelation(menuIds, id);
            redisTemplate.delete("admin");
            return j > 0;
        }
        return false;
    }

}
