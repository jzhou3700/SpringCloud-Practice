package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.stereotype.Component;

@Component
public class PayFeignSentinelApiFallback implements PayFeignSentinelApi
{
    @Override
    public ResultData getPayByOrderNo(String orderNo) {
        return ResultData.fail("500","服务降级处理");
    }
}
