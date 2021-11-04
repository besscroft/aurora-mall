package com.besscroft.aurora.mall.log;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Slf4j
@EnableDiscoveryClient
@MapperScan("com.besscroft.aurora.mall.log.mapper")
@SpringBootApplication
public class MallLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallLogApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  极光商城日志系统启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
