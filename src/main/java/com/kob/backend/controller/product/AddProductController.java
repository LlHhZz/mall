package com.kob.backend.controller.product;

import com.kob.backend.service.user.product.AddProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@RestController
public class AddProductController {
    @Autowired
    private AddProductService addProductService;

    private String uploadPath = "E:/to_do_list/KoBGame/backend/src/main/resources/static/image";
    private String urlImage = "http://localhost:3000/image/";

    @PostMapping("/product/add/")
    public Map<String, String> add(@RequestParam Map<String, String> map, @RequestParam("photo") MultipartFile photoFile) {
        String photoUrl = "";
        try {
            String photoFormat = photoFile.getOriginalFilename().substring(photoFile.getOriginalFilename().lastIndexOf("."));
            String photoFileName = UUID.randomUUID().toString() + photoFormat; // 生成随机文件名
            String photoFilePath = uploadPath + File.separator + photoFileName;
            File dest = new File(photoFilePath);
            photoFile.transferTo(dest);
            photoUrl = urlImage + photoFileName;
        } catch (IOException e) {
            e.printStackTrace();
        }

        String title = map.get("title");
        Integer stock = Integer.parseInt(map.get("stock"));
        Float price = Float.parseFloat(map.get("price"));
        String descb = map.get("descb");
        String size = map.get("size");
        String status = map.get("status");

        return addProductService.add(title, stock, price, descb, size, status, photoUrl);
    }
}