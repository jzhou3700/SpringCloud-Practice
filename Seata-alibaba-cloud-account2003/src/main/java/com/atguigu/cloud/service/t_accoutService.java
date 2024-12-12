package com.atguigu.cloud.service;

import com.atguigu.cloud.t_accout;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 95279
* @description 针对表【t_accout】的数据库操作Service
* @createDate 2024-12-11 11:27:16
*/
public interface t_accoutService extends IService<t_accout> {

    void   decrease(Long userId, Integer money);
}
