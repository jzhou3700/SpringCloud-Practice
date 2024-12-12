package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.mapper.t_storageMapper;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.StorageService;
import com.atguigu.cloud.t_storage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
* @author 95279
* @description 针对表【t_storage】的数据库操作Service实现
* @createDate 2024-12-11 10:53:05
*/
@Service
@Slf4j
public class t_storageServiceImpl extends ServiceImpl<t_storageMapper, t_storage>
    implements StorageService {

    @Resource
    private t_storageMapper t_storageMapper;

    @Override
    public void decrease(Long productId, Integer count){
        log.info("storage-service: decrease开始");
        t_storage t_storage = t_storageMapper.selectById(productId);
        if(t_storage.getResidue() < count){
            throw new RuntimeException("库存不足");
        }
        t_storage.setResidue(t_storage.getResidue()-count);
        t_storage.setUsed(t_storage.getUsed()+count);
        System.out.println(t_storage);
//        this.updateById(t_storage);
        t_storageMapper.decrease(productId,count);
    }
}




