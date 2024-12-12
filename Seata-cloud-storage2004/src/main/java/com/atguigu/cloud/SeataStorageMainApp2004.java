package com.atguigu.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.atguigu.cloud.mapper")
public class SeataStorageMainApp2004 {
    public static void main(String[] args) {
        SpringApplication.run(SeataStorageMainApp2004.class, args);
    }
}
