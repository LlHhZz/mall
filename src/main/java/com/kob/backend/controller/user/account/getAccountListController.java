package com.kob.backend.controller.user.account;

import com.kob.backend.pojo.User;
import com.kob.backend.service.user.account.GetAccountListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class getAccountListController {
    @Autowired
    private GetAccountListService getAccountListService;

    @GetMapping("/user/account/getlist/")
    public List<User> getList() {
        return getAccountListService.getList();
    }
}