package com.atguigu.cloud.service;

import com.atguigu.cloud.domain.t_storage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 95279
* @description 针对表【t_storage】的数据库操作Service
* @createDate 2024-12-12 15:37:53
*/
public interface t_storageService extends IService<t_storage> {

    void decrease(Long productId, Integer count);
}
