package com.atguigu.cloud.contoller;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.t_storageService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StorageController {

    @Resource
    private t_storageService storageService;

    @RequestMapping("/storage/decrease")
    public ResultData<String> decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);

        return ResultData.success( "库存扣减成功");
    }
}
