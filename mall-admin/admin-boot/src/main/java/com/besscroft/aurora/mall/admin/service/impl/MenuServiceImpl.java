package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.besscroft.aurora.mall.admin.mapper.AuthMenuMapper;
import com.besscroft.aurora.mall.admin.service.MenuService;
import com.besscroft.aurora.mall.common.constant.SystemConstants;
import com.besscroft.aurora.mall.common.entity.AuthMenu;
import com.besscroft.aurora.mall.common.exception.NotPermissionException;
import com.besscroft.aurora.mall.common.model.MetaVo;
import com.besscroft.aurora.mall.common.model.RouterVo;
import com.github.pagehelper.PageHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author Bess Croft
 * @Date 2021/3/21 19:15
 */
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<AuthMenuMapper, AuthMenu> implements MenuService {

    private final RedisTemplate<String, Object> redisTemplate;

    @Value("${spring.profiles.active}")
    private String env;

    @Override
    public Map<String, Object> getTreeListById(Long adminId) {
        Map<String, Object> data = (Map<String, Object>) redisTemplate.boundHashOps("admin").get("user:tree:" + adminId);
        if (CollUtil.isEmpty(data)) {
            synchronized (this) {
                data = (Map<String, Object>) redisTemplate.boundHashOps("admin").get("user:tree:" + adminId);
                if (CollUtil.isEmpty(data)) {
                    List<AuthMenu> menuList = this.baseMapper.getListById(adminId);
                    List<AuthMenu> menus = getMenus(menuList);
                    List<RouterVo> routerVoList = getRouter(menus);
                    data = new HashMap<>();
                    data.put("menus", routerVoList);
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
                    menuList = this.baseMapper.getListById(adminId);
                    List<AuthMenu> menus = getMenus(menuList);
                    redisTemplate.opsForValue().set("admin:menu:user:" + adminId, menuList);
                }
            }
        }
        return menuList;
    }

    @Override
    public List<AuthMenu> getMenuAllList() {
        return this.baseMapper.selectList(new QueryWrapper<>());
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
        if (Objects.equals(id, 1L) && SystemConstants.SYSTEM_PROD_ENV.equals(env)) {
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

    /**
     * 菜单层级处理
     * @param menuList 菜单
     * @return 菜单
     */
    private List<AuthMenu> getMenus(List<AuthMenu> menuList) {
        List<AuthMenu> parentMenus = menuList.stream().filter(menu -> menu.getParentId() == 0).collect(Collectors.toList());
        List<AuthMenu> menus = menuList.stream().filter(menu -> menu.getParentId() != 0).collect(Collectors.toList());
        parentMenus.forEach(menu -> {
            List<AuthMenu> childMenu = getChildMenu(menu.getId(), menus);
            menu.setChildren(childMenu);
        });
        return parentMenus;
    }

    /**
     * 菜单递归
     * @param menuId 菜单id
     * @param menuList 子菜单集合
     * @return 菜单
     */
    private List<AuthMenu> getChildMenu(Long menuId, List<AuthMenu> menuList) {
        List<AuthMenu> menus = menuList.stream().filter(menu -> menu.getParentId() == menuId).collect(Collectors.toList());
        menus.forEach(menu -> {
            List<AuthMenu> childMenu = getChildMenu(menu.getId(), menuList);
            menu.setChildren(childMenu);
        });
        return menus;
    }

    /**
     * 获取路由信息
     * @param menuList 菜单
     * @return 路由
     */
    private List<RouterVo> getRouter(List<AuthMenu> menuList) {
        List<RouterVo> routerVoList = new LinkedList<>();
        menuList.forEach(menuDto -> {
            RouterVo routerVo = new RouterVo();
            routerVo.setName(menuDto.getName());
            routerVo.setPath(menuDto.getPath());
            routerVo.setHidden(menuDto.getHidden() != 0);
            routerVo.setComponent(menuDto.getComponent());
            routerVo.setMeta(new MetaVo(menuDto.getTitle(), menuDto.getIcon(), false));
            if (menuDto.getChildren().size() > 0 && !menuDto.getChildren().isEmpty()) {
                routerVo.setAlwaysShow(true);
                routerVo.setRedirect("noRedirect");
                List<RouterVo> childRouter = getChildRouter(menuDto.getChildren());
                routerVo.setChildren(childRouter);
            }
            routerVoList.add(routerVo);
        });
        return routerVoList;
    }

    /**
     * 子路由处理
     * @param menuList 子菜单
     * @return 子路由
     */
    private List<RouterVo> getChildRouter(List<AuthMenu> menuList) {
        List<RouterVo> list = new ArrayList<>();
        menuList.forEach(child -> {
            RouterVo router = new RouterVo();
            router.setPath(child.getPath());
            router.setName(child.getName());
            router.setComponent(child.getComponent());
            router.setMeta(new MetaVo(child.getTitle(), child.getIcon(), false));
            router.setHidden(child.getHidden() != 0);
            if (child.getChildren().size() > 0 && !child.getChildren().isEmpty()) {
                List<RouterVo> childRouter = getChildRouter(child.getChildren());
                router.setChildren(childRouter);
            }
            list.add(router);
        });
        return list;
    }

}
