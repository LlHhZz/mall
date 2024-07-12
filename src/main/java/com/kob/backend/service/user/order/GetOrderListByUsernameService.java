package com.kob.backend.service.user.order;

import com.kob.backend.pojo.UserOrder;

import java.util.List;

public interface GetOrderListByUsernameService {
    List<UserOrder> getListByUsername(String username);
}