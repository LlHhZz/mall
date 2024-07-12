package com.kob.backend.service.user.order;

import com.kob.backend.pojo.UserOrder;

import java.util.List;

public interface GetOrderListAllService {
    List<UserOrder> getList();
}