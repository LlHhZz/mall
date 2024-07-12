package com.kob.backend.service.user.cart;

import java.util.Map;

public interface AddCartService {
    Map<String, String> add(String username, String title, Double price, String image, Integer quantity, Double amount, String size, Boolean selected);
}