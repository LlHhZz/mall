package com.kob.backend.service.impl.cart;


import com.kob.backend.mapper.CartMapper;
import com.kob.backend.pojo.Cart;
import com.kob.backend.service.user.cart.AddCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddCartServiceImpl implements AddCartService {
    @Autowired
    private CartMapper cartMapper;
    @Override
    public Map<String, String> add(String username, String title, Double price, String image, Integer quantity, Double amount, String size, Boolean selected) {
        Map<String, String> map = new HashMap<>();

        Cart cart = new Cart(null, username, title, price, image, quantity, amount, size, selected);
        cartMapper.insert(cart);

        map.put("error_message", "success");
        return map;
    }
}
