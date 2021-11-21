package com.besscroft.aurora.mall.auth.fallback;

import com.besscroft.aurora.mall.auth.AdminFeignClient;
import com.besscroft.aurora.mall.common.domain.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Bess Croft
 * @Time 2021/11/21 12:20
 */
@Slf4j
@Component
public class AdminFeignFallbackClient implements AdminFeignClient {

    @Override
    public UserDto loadUserByUsername(String username) {
        log.error("feign远程调用系统用户服务异常后的降级方法");
        return null;
    }

}
