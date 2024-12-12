package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.t_accoutService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class AccountController {

    @Resource
    private t_accoutService accoutService;

    @RequestMapping("/account/decrease")
    public void decrease(@RequestParam("userId") Long userId, @RequestParam("money") Integer money) throws InterruptedException {
        TimeUnit.SECONDS.sleep(20);
        log.info("account-service: decrease开始");
        accoutService.decrease(userId,money);
    }
}
