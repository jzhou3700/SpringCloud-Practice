package com.atguigu.cloud;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class EmpowerController {

    @GetMapping("/empower")
    public String empower() {
        log.info("测试sentinel授权访问接口");
        return " empower ";
    }
}
