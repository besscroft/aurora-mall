package com.besscroft.aurora.mall.elasticsearch.config;

import com.besscroft.aurora.mall.common.config.BaseSwaggerConfig;
import com.besscroft.aurora.mall.common.domain.SwaggerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Author Bess Croft
 * @Date 2021/5/9 21:32
 */
@Configuration
@EnableSwagger2
@Profile(value = {"dev"})
public class SwaggerConfiguration extends BaseSwaggerConfig {

    @Override
    public SwaggerProperties swaggerProperties() {
        return SwaggerProperties.builder()
                .apiBasePackage("com.besscroft.aurora.mall.elasticsearch.controller")
                .title("极光商城开发文档")
                .description("Elasticsearch相关接口文档")
                .contactName("Bess Croft")
                .contactEmail("besscroft@foxmail.com")
                .contactUrl("https://github.com/besscroft/aurora-mall")
                .license("Open Source")
                .licenseUrl("https://github.com/besscroft/aurora-mall/blob/main/LICENSE")
                .version("0.0.1")
                .enableSecurity(true)
                .build();
    }

}
