package com.kob.backend.controller.user.account;

import com.kob.backend.service.user.account.ModifyPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ModifyPasswordController {

    @Autowired
    private ModifyPasswordService modifyPasswordService;

    @PostMapping("/user/account/modify-password/")
    public Map<String, String> modifyPassword(@RequestParam Map<String, String> map) {
        String username = map.get("username");
        String oldPassword = map.get("oldPassword");
        String newPassword = map.get("newPassword");
        String confirmedNewPassword = map.get("confirmedNewPassword");

        return modifyPasswordService.modify(username, oldPassword, newPassword, confirmedNewPassword);
    }
}
