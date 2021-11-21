package com.besscroft.aurora.mall.auth;

import com.besscroft.aurora.mall.auth.fallback.UserFeignFallbackClient;
import com.besscroft.aurora.mall.common.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/11/21 15:08
 */
@FeignClient(value = "mall-user", fallback = UserFeignFallbackClient.class)
public interface UserFeignClient {

    /**
     * 根据用户名获取用户登录信息
     * @param username 用户名
     * @return 用户登录信息
     */
    @GetMapping("/user/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);

}
