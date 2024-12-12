package com.atguigu.cloud;

import com.atguigu.cloud.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class FlowLimitController {

    @Resource
    private FlowLimitService flowLimitService;
    @GetMapping("/test1")
    public String test1() {
        return "------test1";
    }
    @GetMapping("/test2")
    public String test2() {
        return "------test2";
    }

    @GetMapping("/test3")
    public String test3() {
        flowLimitService.common();
        return "------test3";
    }

    // sentinel链路流控，
    @GetMapping("/test4")
    public String test4() {
        flowLimitService.common();
        return "------test4";
    }

    @GetMapping("/test5")
    public String test5() {
        System.out.println(System.currentTimeMillis() + "------test5");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return System.currentTimeMillis() + "------test5";
    }
}
