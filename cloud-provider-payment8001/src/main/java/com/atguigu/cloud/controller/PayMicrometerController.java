package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayMicrometerController {

    @GetMapping("/pay/micrometer/{id}")
    public String payMicrometer(@PathVariable("id") Integer id){
        return "hello,欢迎来到myMicrometer inputId："+id+"\t"+ IdUtil.simpleUUID();
    }
}
