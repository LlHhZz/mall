package com.kob.backend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kob.backend.pojo.UserOrder;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<UserOrder> {
}