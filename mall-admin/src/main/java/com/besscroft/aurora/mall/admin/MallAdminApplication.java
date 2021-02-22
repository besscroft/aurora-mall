package com.besscroft.aurora.mall.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.besscroft.aurora.mall.admin.mapper")
public class MallAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallAdminApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  极光商城管理系统启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
