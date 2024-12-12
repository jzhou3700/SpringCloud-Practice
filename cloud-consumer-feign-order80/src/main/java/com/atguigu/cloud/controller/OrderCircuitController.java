package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@RestController
public class OrderCircuitController {

    @Resource
    private PayFeignApi payFeignApi;

//    @GetMapping("/feign/pay/circuit/{id}")
//    @CircuitBreaker(name = "cloud-payment-service",fallbackMethod = "myCircuitFallback")
//    public String circuitBreaker(@PathVariable("id") Integer id){
//        return payFeignApi.circuitBreaker(id);
//    }
//    public String myCircuitFallback(Throwable throwable){
//        return "myCircuitFallback,系统繁忙，请稍后再试----/(ToT)/";
//    }
//    @GetMapping("/Feign/pay/circuit/{id}")
//    @CircuitBreaker(name = "cloud-payment-service",fallbackMethod = "myCircuitFallback")
//    public String circuitBreaker(@PathVariable("id") Integer id){
//        return payFeignApi.circuitBreaker(id);
//    }
//    public String myCircuitFallback(Throwable throwable){
//        return "myCircuitFallback,系统繁忙，请稍后再试----/(ToT)/";
//    }

//    @GetMapping("/pay/bulkhead/{id}")
//    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadFallback",type = Bulkhead.Type.THREADPOOL)
//    public String bulkhead(@PathVariable("id") Integer id){
//        return payFeignApi.bulkhead(id);
//    }

    public String myBulkheadFallback(Throwable throwable) {
        return "myBulkheadFallback,系统繁忙，请稍后再试----/(ToT)/";
    }

    @GetMapping("/Feign/pay/bulkhead/{id}")
    @Bulkhead(name = "cloud-payment-service",fallbackMethod = "myBulkheadPoolFallback",type = Bulkhead.Type.THREADPOOL)
    public CompletableFuture<String> bulkhead(@PathVariable("id") Integer id){
        System.out.println(Thread.currentThread().getName()+"\t"+"--开始进入");
        try{
            TimeUnit.SECONDS.sleep(5);}
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return CompletableFuture.supplyAsync(()->
                payFeignApi.bulkhead(id)+ "\t"+"Bulkhead.Type.SEMAPHORE");
    }
    public CompletableFuture<String> myBulkheadPoolFallback(Throwable throwable) {
        return CompletableFuture.supplyAsync(()->"myBulkheadPoolFallback,系统繁忙，请稍后再试----/(ToT)/");
    }

    @GetMapping("/feign/pay/rate/{id}")
    @RateLimiter(name = "cloud-payment-service",fallbackMethod = "myRateLimitFallback")
    public String rateLimit(@PathVariable("id") Integer id){
        return payFeignApi.rateLimit(id);
    }

    // 回退方法
    public String myRateLimitFallback(Integer id, Throwable throwable) {
        return "myRateLimitFallback, 系统繁忙，请稍后再试 ----/(ToT)/";
    }
}
