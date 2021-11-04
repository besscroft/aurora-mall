package com.besscroft.aurora.mall.admin;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.besscroft.aurora.mall.admin.mapper")
public class MallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  极光商城管理系统启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
