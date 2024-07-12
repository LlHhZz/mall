package com.kob.backend.controller.cart;

import com.kob.backend.service.user.cart.AddCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddCartController {
    @Autowired
    private AddCartService addCartService;

    @PostMapping("/cart/add/")
    public Map<String, String> add(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String title = map.get("title");
        Double price = Double.parseDouble(map.get("price"));
        String image = map.get("image");
        Integer quantity = Integer.parseInt(map.get("quantity"));
        Double amount = Double.parseDouble(map.get("amount"));
        String size = map.get("size");
        Boolean selected = Boolean.parseBoolean(map.get("selected"));

        return addCartService.add(username, title, price, image, quantity, amount, size, selected);
    }
}