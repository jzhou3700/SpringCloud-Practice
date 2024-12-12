package com.atguigu.cloud;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.entity.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class PayAlibabaController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/pay/nacos/{id}")
    public String getPaymentPort(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort:"+port+"\t id:"+id;
    }

    @GetMapping("/pay/nacos/get/{orderNo}")
    @SentinelResource(value = "getPayByOrderNo",blockHandler = "handlerBlockHandler")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo)
    {
        PayDTO payDTO = new PayDTO();

        payDTO.setId(1024);
        payDTO.setOrderNo(orderNo);
        payDTO.setAmount(BigDecimal.valueOf(9.9));
        payDTO.setPayNo("pay:"+ IdUtil.fastUUID());
        payDTO.setUserId(1);
        return ResultData.success(payDTO);
    }
    public ResultData handlerBlockHandler(String orderNo, BlockException e)
    {
        return ResultData.fail(ReturnCodeEnum.INTERNAL_SERVER_ERROR.getCode(),"getPayByOrderNo服务不可用，"+"触发sentinel流控配置规则"+"\t");
    }
}
