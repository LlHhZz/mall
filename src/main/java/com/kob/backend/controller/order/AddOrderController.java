package com.kob.backend.controller.order;

import com.kob.backend.service.user.order.AddOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@RestController
public class AddOrderController {
    @Autowired
    private AddOrderService addOrderService;
    @PostMapping("/order/add/")
    public Map<String, String> add(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String title = map.get("title");

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatterCreationTime = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedCreationTime = localDateTime.format(formatterCreationTime);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date creationTime = null;
        try {
            creationTime = formatter.parse(formattedCreationTime);
        } catch (ParseException e) {
            e.printStackTrace(); // 处理日期格式解析异常
        }
        Date updateTime = creationTime;

        Double price = Double.parseDouble(map.get("price"));
        Integer quantity = Integer.parseInt(map.get("quantity"));
        String size = map.get("size");
        Double amount = Double.parseDouble(map.get("amount"));
        String image = map.get("image");
        String status = map.get("status");
        String deliveryAddress = map.get("deliveryAddress");

        return addOrderService.add(creationTime, updateTime, username, title, price, quantity, size, amount, image, status, deliveryAddress);
    }
}