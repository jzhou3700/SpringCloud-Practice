package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.apis.AccountFeignApi;
import com.atguigu.cloud.service.t_orderService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.cloud.entities.Order;
import com.atguigu.cloud.mapper.orderMapper;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;
import com.atguigu.cloud.apis.StorageFeignApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* @author 95279
* @description 针对表【t_order】的数据库操作Service实现
* @createDate 2024-12-07 21:48:28
*/
@Service
@Slf4j
public class t_orderServiceImpl extends ServiceImpl<orderMapper, Order>
    implements t_orderService {

    @Resource
    private orderMapper t_orderMapper;

    @Resource
    private StorageFeignApi storageFeignApi;

    @Resource
    private AccountFeignApi accountFeignApi;

    @Override
    @GlobalTransactional(name="create-order",rollbackFor = Exception.class)
    public void create(Order order) {

        String xid = RootContext.getXID();

        log.info("-------------------开始新建订单"+"\t"+"xid: "+xid);
        order.setStatus(0);
        int result = t_orderMapper.insert(order);

        if(result>0){
            Order orderFromDB = t_orderMapper.selectById(order.getId());
            log.info("------->新建订单成功，orderFromDB info:"+orderFromDB);
            System.out.println();

            //扣减库存
            log.info("------->订单微服务开始调用库存，做扣减Count");
            storageFeignApi.decrease(order.getProductId(),order.getCount());

            //扣减账户
            log.info("------->订单微服务开始调用账户，做扣减Money");
            accountFeignApi.decrease(order.getUserId(),order.getMoney());
            log.info("------->扣减库存和账户余额结束");

            //修改订单状态，从0到1，1代表已完成
            log.info("------->修改订单状态开始");
            orderFromDB.setStatus(1);
            t_orderMapper.updateById(orderFromDB);
        }
        System.out.println();
        log.info("----------------结束新建订单："+"\t"+"xid: "+xid);

    }

}




