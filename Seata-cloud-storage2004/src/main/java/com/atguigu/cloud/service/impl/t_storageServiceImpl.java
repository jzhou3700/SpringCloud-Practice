package com.atguigu.cloud.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.atguigu.cloud.domain.t_storage;
import com.atguigu.cloud.service.t_storageService;
import com.atguigu.cloud.mapper.t_storageMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
* @author 95279
* @description 针对表【t_storage】的数据库操作Service实现
* @createDate 2024-12-12 15:37:53
*/
@Service
public class t_storageServiceImpl extends ServiceImpl<t_storageMapper, t_storage>
    implements t_storageService{

    @Resource
    private t_storageMapper t_storageMapper;

    @Override
    public void decrease(Long productId, Integer count) {
        t_storage storage = this.baseMapper.selectById(productId);
        storage.setResidue(storage.getResidue() - count);
        storage.setUsed(storage.getUsed() + count);
//        t_storageMapper.decrease(productId,count);
        t_storageMapper.updateById(storage);
    }

}




