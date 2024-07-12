package com.kob.backend.service.user.cart;

import com.kob.backend.pojo.Cart;

import java.util.List;

public interface GetCartListByUsernameService {
    List<Cart> getListByUsername(String username);
}