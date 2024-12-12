

package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    @Resource
    private PayFeignApi payFeignApi;

    @PostMapping("/Feign/pay/add")
    public ResultData addOrder(@RequestBody PayDTO payDTO){
        System.out.println("第一步：模拟本地addOrder新增订单成功）");
        System.out.println();
        return payFeignApi.addPay(payDTO);
    }

    @GetMapping("/Feign/pay/get/{id}")
    public ResultData getOrder(@PathVariable("id") Integer id){
        System.out.println("-----支付微服务远程调用，按照id查询订单支付流水信息");
        ResultData resultData = null;
        try{
            System.out.println("调用开始---："+ DateUtil.now());
            resultData = payFeignApi.getPay(id);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("调用结束---："+ DateUtil.now());
            ResultData.fail(ReturnCodeEnum.PARAM_ERROR.getCode(),e.getMessage());
        }
        return resultData;
    }

    @GetMapping("/Feign/pay/mylb")
    public String mylb(){
        return payFeignApi.getBl();
    }


}
