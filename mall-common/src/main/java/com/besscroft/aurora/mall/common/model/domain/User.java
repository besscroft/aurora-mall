package com.besscroft.aurora.mall.common.model.domain;

import com.besscroft.aurora.mall.common.model.BaseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * @Author Besscroft
 * @Date 2021/1/17 14:57
 */
public class User implements UserDetails {

    /** 用户id */
    private Long id;

    /** 用户名 */
    private String username;

    /** 密码 */
    private String password;

    /** 角色 */
    private String roles;

    /** 是否启用 */
    private boolean enable;

    private List<GrantedAuthority> authorityList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
