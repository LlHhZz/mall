package com.kob.backend.service.user.product;

import java.util.Map;

public interface AddProductService {
    Map<String, String> add(String title, Integer stock, Float price, String descb, String size, String status, String photoUrl);
}