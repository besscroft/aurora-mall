package com.besscroft.aurora.mall.auth.service.impl;

import com.besscroft.aurora.mall.auth.AdminFeignClient;
import com.besscroft.aurora.mall.auth.UserFeignClient;
import com.besscroft.aurora.mall.auth.domain.User;
import com.besscroft.aurora.mall.common.constant.AuthConstants;
import com.besscroft.aurora.mall.common.constant.MessageConstant;
import com.besscroft.aurora.mall.common.domain.UserDto;
import lombok.RequiredArgsConstructor;
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
 * @Author Bess Croft
 * @Date 2021/2/17 21:01
 */
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdminFeignClient adminFeignClient;
    private final UserFeignClient userFeignClient;
    private final HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String clientId = request.getParameter(AuthConstants.JWT_CLIENT_ID_KEY);
        UserDto userDto = null;
        switch (clientId) {
            case AuthConstants.ADMIN_CLIENT_ID: // 后台用户
                userDto = adminFeignClient.loadUserByUsername(username);
                break;
            case AuthConstants.PORTAL_CLIENT_ID: // 前台会员
                userDto = userFeignClient.loadUserByUsername(username);
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
