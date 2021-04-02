package com.besscroft.aurora.mall.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.besscroft.aurora.mall.admin.mapper.BmsAuthMenuMapper;
import com.besscroft.aurora.mall.admin.service.MenuService;
import com.besscroft.aurora.mall.common.entity.BmsAuthMenu;
import com.besscroft.aurora.mall.common.model.MetaVo;
import com.besscroft.aurora.mall.common.model.RouterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author Besscroft
 * @Date 2021/3/21 19:15
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private BmsAuthMenuMapper bmsAuthMenuMapper;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public Map<String, Object> getTreeListById(Long adminId) {
        Map<String, Object> data = (Map<String, Object>) redisTemplate.boundHashOps("admin").get("user:tree:" + adminId);
        if (CollUtil.isEmpty(data)) {
            synchronized (this) {
                data = (Map<String, Object>) redisTemplate.boundHashOps("admin").get("user:tree:" + adminId);
                if (CollUtil.isEmpty(data)) {
                    List<BmsAuthMenu> menuList = bmsAuthMenuMapper.getParentListById(adminId);
                    menuList.forEach(menu -> {
                        List<BmsAuthMenu> childListById = bmsAuthMenuMapper.getChildListById(adminId, menu.getId());
                        menu.setChildren(childListById);
                    });
                    List<RouterVo> routerVoList = new LinkedList<>();
                    menuList.forEach(menu -> {
                        RouterVo routerVo = new RouterVo();
                        routerVo.setName(menu.getName());
                        routerVo.setPath(menu.getPath());
                        routerVo.setHidden(menu.getHidden() == 0);
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
                                router.setHidden(child.getHidden() == 0);
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
    public List<BmsAuthMenu> getMenuListById(Long adminId) {
        List<BmsAuthMenu> menuList = (List<BmsAuthMenu>) redisTemplate.opsForValue().get("admin:menu:user:" + adminId);
        if (CollUtil.isEmpty(menuList)) {
            synchronized (this) {
                menuList = (List<BmsAuthMenu>) redisTemplate.opsForValue().get("admin:menu:user:" + adminId);
                if (CollUtil.isEmpty(menuList)) {
                    menuList = bmsAuthMenuMapper.getParentListById(adminId);
                    menuList.forEach(menu -> {
                        List<BmsAuthMenu> childListById = bmsAuthMenuMapper.getChildListById(adminId, menu.getId());
                        menu.setChildren(childListById);
                    });
//                    redisTemplate.delete("admin:menu:user:" + adminId);
                    redisTemplate.opsForValue().set("admin:menu:user:" + adminId, menuList);
                }
            }
        }
        return menuList;
    }

}
