package com.atguigu.cloud;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.atguigu.cloud.mapper")
public class SeataStorageMainApp2002 {
    public static void main(String[] args) {
        System.out.println("库存微服务模块启动成功");
        SpringApplication.run(SeataStorageMainApp2002.class, args);
    }
}
