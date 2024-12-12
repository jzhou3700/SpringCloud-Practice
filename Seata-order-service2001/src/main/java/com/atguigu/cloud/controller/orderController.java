package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.t_orderService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class orderController {

    @Resource
    private t_orderService service;
    @RequestMapping("/order/create")
    public ResultData<String> create(Order order){
        service.create(order);
        return ResultData.success("创建订单成功");
    }
}
