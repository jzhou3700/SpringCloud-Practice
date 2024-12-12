package com.atguigu.cloud;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

@Service
public class FlowLimitService {
    @SentinelResource(value = "ordering1")
    public void common() {
        System.out.println("common");
    }

}
