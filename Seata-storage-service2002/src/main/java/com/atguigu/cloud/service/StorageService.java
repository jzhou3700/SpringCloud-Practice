package com.atguigu.cloud.service;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.t_storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 95279
* @description 针对表【t_storage】的数据库操作Service
* @createDate 2024-12-11 10:53:05
*/
public interface StorageService extends IService<t_storage> {

    public void decrease(Long productId, Integer count);
}
