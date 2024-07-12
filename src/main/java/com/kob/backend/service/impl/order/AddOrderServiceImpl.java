package com.kob.backend.service.impl.order;

import com.kob.backend.mapper.CartMapper;
import com.kob.backend.mapper.OrderMapper;
import com.kob.backend.pojo.Cart;
import com.kob.backend.pojo.User;
import com.kob.backend.pojo.UserOrder;
import com.kob.backend.service.user.cart.AddCartService;
import com.kob.backend.service.user.order.AddOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class AddOrderServiceImpl implements AddOrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Map<String, String> add(Date creationTime, Date updateTime, String username, String title, Double price, Integer quantity, String size, Double amount, String image, String status, String deliveryAddress) {
        Map<String, String> map = new HashMap<>();

        UserOrder userOrder = new UserOrder(null, creationTime, updateTime, username, title, price, quantity, size, amount, image, status, deliveryAddress);
        orderMapper.insert(userOrder);

        map.put("error_message", "success");
        return map;
    }
}
