package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class OrderGateWayController {

    @Resource
    private PayFeignApi payFeignApi;

    @GetMapping("/Feign/pay/gateway/get/{id}")
//    @RateLimiter(name = "cloud-payment-service",fallbackMethod = "myRateLimitFallback")
    public ResultData getById(@PathVariable("id") Integer id){
        return payFeignApi.getById(id);
    }

    @GetMapping("/Feign/pay/gateway/info")
    public ResultData getGatewayInfo(){
        return payFeignApi.getGatewayInfo();
    }
}
