package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.atguigu.cloud.entity.TPay;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.TPayService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Iterator;

@RestController
public class PayGateWayController {
    @Resource
    private TPayService tPayService;






    @GetMapping("/pay/gateway/get/{id}")
    @Operation(summary = "获取支付记录")
    public ResultData<TPay> getPaybyId(@PathVariable("id") Integer id) {
//        PayDTO payDTO = new PayDTO();
//        BeanUtils.copyProperties(tPayService.getById(id), payDTO);
        return ResultData.success(tPayService.getById(id));
    }

    @Value("${server.port}")
    private String port;

    @GetMapping("/pay/gateway/info")
    public ResultData<String> getInfoByConsul() {
        return ResultData.success("gateway info:" + IdUtil.simpleUUID()+"\t"+port);
    }

    @GetMapping("/pay/gateway/filter")
    public ResultData<String> filter(HttpServletRequest request) {
        Iterator headerNames =  request.getHeaderNames().asIterator();
        String result = "";
        while (headerNames.hasNext()) {
            String name = (String) headerNames.next();
            String value = request.getHeader(name);
            System.out.println(name + ":" + value);
            if(name.equals("X-Request-atguigu1")
                    ||name.equals("X-Request-atguigu2")){
                result = result + headerNames.toString()+":"+value+"\t";
            }
        }
        return ResultData.success("gateWayFilter 过滤器："+result+"\t"+ DateUtil.now());
    }
}
