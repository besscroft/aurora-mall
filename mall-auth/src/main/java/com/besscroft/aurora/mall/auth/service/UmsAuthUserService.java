package com.besscroft.aurora.mall.auth.service;

import com.besscroft.aurora.mall.common.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 用户系统请求服务
 *
 * @Author Besscroft
 * @Date 2021/2/17 21:17
 */
@FeignClient("mall-user")
public interface UmsAuthUserService {

    /**
     * 根据用户名获取用户登录信息
     * @param username 用户名
     * @return 用户登录信息
     */
    @GetMapping("/user/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);

}
