package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.mapper.t_accoutMapper;
import com.atguigu.cloud.service.t_accoutService;
import com.atguigu.cloud.t_accout;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author 95279
* @description 针对表【t_accout】的数据库操作Service实现
* @createDate 2024-12-11 11:27:16
*/
@Service
@Slf4j
public class t_accoutServiceImpl extends ServiceImpl<t_accoutMapper, t_accout>
    implements t_accoutService{

    @Override
    public void   decrease(Long userId, Integer money){
        log.info("account-service: decrease开始");
        t_accout accout = this.getById(userId);
        accout.setUsed(accout.getUsed()+money);
        accout.setResidue(accout.getResidue()-money);
        this.updateById(accout);
        log.info("account-service: decrease结束");
    }

}




