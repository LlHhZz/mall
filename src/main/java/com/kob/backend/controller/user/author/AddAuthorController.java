package com.kob.backend.controller.user.author;

import com.kob.backend.service.user.author.AddAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AddAuthorController {
    @Autowired
    private AddAuthorService addAuthorService;

    @PostMapping("/user/author/add/")
    public Map<String, String> add(@RequestParam Map<String, String> data) {
        return addAuthorService.add(data);
    }
}
