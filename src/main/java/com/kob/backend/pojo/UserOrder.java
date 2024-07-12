package com.kob.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder {
    @TableId(type = IdType.AUTO)
    private Integer id;  // 总品类ID
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date creationTime;  // 订单创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;  // 订单状态最近更新时间
    private String username;  // 和用户相匹配
    private String title;  // 商品名称
    private Double price;
    private Integer quantity;
    private String size;
    private Double amount;
    private String image;
    private String status;  // 10为待发货 -> 管理员发货 -> 20为待收货 -> 用户确认收货 -> 30为已收货（交易完成）
    private String deliveryAddress;
}


/*
CREATE TABLE user_order (
    id INT AUTO_INCREMENT PRIMARY KEY,
    creation_time DATETIME NOT NULL,
    update_time DATETIME NOT NULL,
    username VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    quantity INT NOT NULL,
    size VARCHAR(255),
    amount DECIMAL(10, 2) NOT NULL,
    image VARCHAR(255),
    status VARCHAR(50),
    delivery_address VARCHAR(255)
);
* */