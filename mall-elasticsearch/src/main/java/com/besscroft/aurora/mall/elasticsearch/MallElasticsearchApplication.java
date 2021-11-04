package com.besscroft.aurora.mall.elasticsearch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@Slf4j
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MallElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallElasticsearchApplication.class, args);
        log.info("(♥◠‿◠)ﾉﾞ  极光商城 Elasticsearch 中心启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
