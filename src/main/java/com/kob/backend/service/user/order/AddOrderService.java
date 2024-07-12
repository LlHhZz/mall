package com.kob.backend.service.user.order;

import java.util.Date;
import java.util.Map;

public interface AddOrderService {
    Map<String, String> add(Date creationTime, Date updateTime, String username, String title, Double price, Integer quantity, String size, Double amount, String image, String status, String deliveryAddress);
}