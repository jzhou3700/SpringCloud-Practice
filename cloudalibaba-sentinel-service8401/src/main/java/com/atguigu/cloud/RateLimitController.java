package com.atguigu.cloud;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RateLimitController {

    @GetMapping("/rateLimit/byUrl")
    public String byUrl()
    {
        return "------byUrl";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testhotKey",blockHandler = "dealhandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "------testHotKey";
    }

    public String dealhandler_testHotKey(String p1, String p2, BlockException exception){
        return "------dealhandler_testHotKey,o(╥﹏╥)o";
    }
}
