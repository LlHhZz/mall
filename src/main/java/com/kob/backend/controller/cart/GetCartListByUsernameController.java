package com.kob.backend.controller.cart;

import com.kob.backend.pojo.Cart;
import com.kob.backend.service.user.cart.GetCartListByUsernameService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class GetCartListByUsernameController {
    @Autowired
    private GetCartListByUsernameService getCartListByUsernameService;

    @PostMapping("/cart/getlist/byUsername/")
    public List<Cart> getListByUsername(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        return getCartListByUsernameService.getListByUsername(username);
    }
}