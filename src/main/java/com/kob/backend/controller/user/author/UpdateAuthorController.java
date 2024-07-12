package com.kob.backend.controller.user.author;

import com.kob.backend.service.user.author.UpdateAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UpdateAuthorController {
    @Autowired
    private UpdateAuthorService updateAuthorService;

    @PostMapping("/user/author/update/")
    public Map<String, String> update(@RequestParam Map<String, String> data) {
        return updateAuthorService.update(data);
    }
}
