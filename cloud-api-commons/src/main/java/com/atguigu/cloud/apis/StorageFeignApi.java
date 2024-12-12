package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("seata-storage-service")
public interface StorageFeignApi {

    @PostMapping("/storage/decrease")
    void decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}
