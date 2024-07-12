package com.kob.backend.service.impl.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.ProductMapper;
import com.kob.backend.pojo.Product;
import com.kob.backend.pojo.User;
import com.kob.backend.service.user.product.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AddProductServiceImpl implements AddProductService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public Map<String, String> add(String title, Integer stock, Float price, String descb, String size, String status, String photoUrl) {
        Map<String, String> map = new HashMap<>();

        // 查看数据库中是否已存在该商品
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        Product product = new Product(null, title, stock, descb, photoUrl, price, size, status);
        productMapper.insert(product);

        map.put("error_message", "success");
        return map;
    }
}