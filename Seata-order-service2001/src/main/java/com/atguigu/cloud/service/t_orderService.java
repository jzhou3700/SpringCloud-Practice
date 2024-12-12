package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 95279
* @description 针对表【t_order】的数据库操作Service
* @createDate 2024-12-07 21:48:28
*/
public interface t_orderService extends IService<Order> {

    void create(Order order);
}
