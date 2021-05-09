package com.besscroft.aurora.mall.elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
public class MallElasticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallElasticsearchApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  极光商城 Elasticsearch 中心启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
