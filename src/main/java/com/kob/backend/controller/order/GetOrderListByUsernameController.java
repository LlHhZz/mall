package com.kob.backend.controller.order;

import com.kob.backend.pojo.UserOrder;
import com.kob.backend.service.user.order.GetOrderListByUsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetOrderListByUsernameController {
    @Autowired
    private GetOrderListByUsernameService getOrderListByUsernameService;

    @PostMapping("/order/getlist/byUsername/")
    public List<UserOrder> getListByUsername(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        return getOrderListByUsernameService.getListByUsername(username);
    }
}