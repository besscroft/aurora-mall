package com.besscroft.aurora.mall.gateway;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * blocking will cause a webflux application to break.
 */
@Slf4j
@SpringBootApplication
@EnableDiscoveryClient
public class MallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallGatewayApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  极光商城网关启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
