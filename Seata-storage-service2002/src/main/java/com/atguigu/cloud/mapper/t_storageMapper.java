package com.atguigu.cloud.mapper;

import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.t_storage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
* @author 95279
* @description 针对表【t_storage】的数据库操作Mapper
* @createDate 2024-12-11 10:53:05
* @Entity com.atguigu.cloud.t_storage
*/
public interface t_storageMapper extends BaseMapper<t_storage> {

    void decrease(@Param("productId") Long productId, @Param("count") Integer count);
}




