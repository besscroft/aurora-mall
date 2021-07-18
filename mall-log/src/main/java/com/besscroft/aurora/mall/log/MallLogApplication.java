package com.besscroft.aurora.mall.log;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@MapperScan("com.besscroft.aurora.mall.log.mapper")
@SpringBootApplication
public class MallLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallLogApplication.class, args);
    }

}
