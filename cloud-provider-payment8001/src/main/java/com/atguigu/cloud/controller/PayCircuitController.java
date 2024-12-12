package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PayCircuitController {

    @GetMapping("/pay/circuit/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("id不能为负数");
        }
        if(id ==9999){
            try{
                TimeUnit.SECONDS.sleep(5);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return "hello, circuit! input id: "+id +"\t"+IdUtil.simpleUUID();
    }

    @GetMapping("/pay/bulkhead/{id}")
    public String bulkhead(@PathVariable("id") Integer id){
        return "hello, bulkhead! input id: "+id +"\t"+IdUtil.simpleUUID();
    }
    @GetMapping("/pay/rate/{id}")
    public String rateLimit(@PathVariable("id") Integer id){
        return "hello, rateLimit! input id: "+id +"\t"+IdUtil.simpleUUID();
    }
}
