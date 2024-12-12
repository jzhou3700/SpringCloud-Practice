package com.atguigu.cloud.controller;

import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class OrderController {

    public static final String PAY_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("/consumer/pay/add")
    public ResultData add(PayDTO payDto) {
        return restTemplate.postForObject(PAY_URL + "/pay/add",payDto, ResultData.class);
    }

    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PAY_URL+"/pay/get/"+id, ResultData.class);
    }

    @GetMapping("/consumer/discovery")
    public String discovery(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println("service = " + service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-provider-payment");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return instances.toString();
    }

    @GetMapping("/consumer/getinfo")
    public String getInfoByConsul(){
        return restTemplate.getForObject(PAY_URL+"/pay/getinfo", String.class);
    }
}
