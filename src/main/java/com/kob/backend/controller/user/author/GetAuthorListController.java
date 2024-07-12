package com.kob.backend.controller.user.author;

import com.kob.backend.pojo.Author;
import com.kob.backend.service.user.author.GetAuthorListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAuthorListController {
    @Autowired
    private GetAuthorListService getAuthorListService;

    @GetMapping("/user/author/getlist/")
    public List<Author> getList() {
        return getAuthorListService.getList();
    }
}
