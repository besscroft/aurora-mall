package com.besscroft.aurora.mall.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.besscroft.aurora.mall.auth.mapper")
@ComponentScan(basePackages = {"com.besscroft.aurora.mall.common.entity","com.besscroft.aurora.mall.common.domain"})
public class MallAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAuthApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  极光商城认证中心启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
