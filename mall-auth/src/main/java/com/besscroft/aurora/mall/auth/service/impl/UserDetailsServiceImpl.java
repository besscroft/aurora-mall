package com.besscroft.aurora.mall.auth.service.impl;

import com.besscroft.aurora.mall.auth.domain.User;
import com.besscroft.aurora.mall.auth.service.BmsAuthUserService;
import com.besscroft.aurora.mall.auth.service.UmsAuthUserService;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.constant.MessageConstant;
import com.besscroft.aurora.mall.common.domain.UserDto;
import lombok.AllArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义用户认证和授权
 *
 * @Author Besscroft
 * @Date 2021/2/17 21:01
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private BmsAuthUserService bmsAuthUserService;

    @Autowired
    private UmsAuthUserService umsAuthUserService;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter(AuthConstants.JWT_CLIENT_ID_KEY);
        UserDto userDto = null;
        switch (clientId) {
            case AuthConstants.ADMIN_CLIENT_ID: // 后台用户
                userDto = bmsAuthUserService.loadUserByUsername(username);
                break;
            case AuthConstants.PORTAL_CLIENT_ID: // 前台会员
                userDto = umsAuthUserService.loadUserByUsername(username);
                break;
        }
        if (userDto == null) {
            throw new UsernameNotFoundException(MessageConstant.USERNAME_PASSWORD_ERROR);
        }
        userDto.setClientId(clientId);
        User user = new User(userDto);
        if (!user.isEnabled()) {
            throw new DisabledException(MessageConstant.ACCOUNT_DISABLED);
        } else if (!user.isAccountNonLocked()) {
            throw new LockedException(MessageConstant.ACCOUNT_LOCKED);
        } else if (!user.isAccountNonExpired()) {
            throw new AccountExpiredException(MessageConstant.ACCOUNT_EXPIRED);
        } else if (!user.isCredentialsNonExpired()) {
            throw new CredentialsExpiredException(MessageConstant.CREDENTIALS_EXPIRED);
        }
        return user;
    }

}
