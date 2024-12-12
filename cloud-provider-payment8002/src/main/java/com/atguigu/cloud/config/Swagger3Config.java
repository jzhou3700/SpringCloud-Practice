package com.atguigu.cloud.config;

import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Swagger3Config {

    @Bean
    public GroupedOpenApi PayApi(){
        return GroupedOpenApi.builder()
               .group("支付微服务模块")
                .pathsToMatch("/pay/**")
               .build();
    }
    public OpenAPI docsOpenApi(){
        return new OpenAPI().info(new io.swagger.v3.oas.models.info.Info().title("支付微服务模块"));
    }
}
