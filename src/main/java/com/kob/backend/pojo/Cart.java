package com.kob.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;  // 和用户相匹配
    private String title;
    private Double price;  // 单价
    private String image;
    private Integer quantity;  // 数量
    private Double amount;  // 总价
    private String size;  // 数量、型号等描述
    private Boolean selected;
}


/*
CREATE TABLE cart (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    title VARCHAR(255) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    image VARCHAR(255),
    quantity INT NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    size VARCHAR(255),
    selected TINYINT(1) DEFAULT 0
);

理论上，可以设置user和cart的级联删除约束
CONSTRAINT FK_user_cart FOREIGN KEY (username)
        REFERENCES user(username)
        ON DELETE CASCADE
* */