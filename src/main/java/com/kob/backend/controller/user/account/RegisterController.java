package com.kob.backend.controller.user.account;

import com.kob.backend.service.user.account.RegisterService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;
import java.util.UUID;

@RestController
public class RegisterController {
    @Autowired
    private RegisterService registerService;

    private String uploadPath = "E:/to_do_list/KoBGame/backend/src/main/resources/static/image";
    private String urlImage = "http://localhost:3000/image/";

    @PostMapping("/user/account/register/")
    public Map<String, String> register(@RequestParam Map<String, String> map, @RequestParam("photo") MultipartFile photoFile) {
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

        String username = map.get("username");
        String password = map.get("password");
        String confirmedPassword = map.get("confirmedPassword");
        String email = map.get("email");
        String birthdate = map.get("birthdate");
        return registerService.register(username, password, confirmedPassword, photoUrl, email, birthdate);
    }
}
