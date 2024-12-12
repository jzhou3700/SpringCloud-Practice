package com.atguigu.cloud.apis;

import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "cloud-gateway")
public interface PayFeignApi {

    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);

    @GetMapping("/pay/get/{id}")
    public ResultData getPay(@PathVariable("id") Integer id);

    @GetMapping("/pay/getinfo")
    public String getBl();

    @GetMapping("/pay/circuit/{id}")
    public String circuitBreaker(@PathVariable("id") Integer id);

    @GetMapping("/pay/bulkhead/{id}")
    public String bulkhead(@PathVariable("id") Integer id);

    @GetMapping("/pay/rate/{id}")
    public String rateLimit(@PathVariable("id") Integer id);

    @GetMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);

    @GetMapping("/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id);

    @GetMapping("/pay/gateway/info")
    public ResultData<String> getGatewayInfo();
}
