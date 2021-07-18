package com.besscroft.idGenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MallIdGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallIdGeneratorApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  分布式id服务启动成功   ლ(´ڡ`ლ)ﾞ  \n");
    }

}
