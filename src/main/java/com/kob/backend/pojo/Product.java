package com.kob.backend.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String title;
    private Integer stock;
    private String descb;  // 注意 不能用desc
    private String image;
    private Float price;
    private String size;  // 各种描述（比如物体个数，手机型号）
    private String status;
}


/*
CREATE TABLE product (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    stock INT NOT NULL,
    descb VARCHAR(255),
    image VARCHAR(255),
    price DECIMAL(10, 2) NOT NULL,
    size VARCHAR(255),
    status VARCHAR(50)
);
* */