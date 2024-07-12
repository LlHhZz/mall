package com.kob.backend.controller.user.author;

import com.kob.backend.service.user.author.RemoveAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class RemoveAuthorController {
    @Autowired
    private RemoveAuthorService removeAuthorService;

    @PostMapping("/user/author/remove/")
    public Map<String, String> remove(@RequestParam Map<String, String> data) {
        return removeAuthorService.remove(data);
    }
}
