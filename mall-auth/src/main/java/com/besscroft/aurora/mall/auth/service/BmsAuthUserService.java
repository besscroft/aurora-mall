package com.besscroft.aurora.mall.auth.service;

import com.besscroft.aurora.mall.common.domain.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 后台用户管理Service
 *
 * @Author Besscroft
 * @Date 2021/1/23 14:53
 */
@FeignClient("mall-admin")
public interface BmsAuthUserService {

    @GetMapping("/user/loadByUsername")
    UserDto loadUserByUsername(@RequestParam String username);
}
