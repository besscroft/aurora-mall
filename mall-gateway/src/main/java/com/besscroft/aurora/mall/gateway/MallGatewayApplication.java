package com.besscroft.aurora.mall.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MallGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallGatewayApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  极光商城网关启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
