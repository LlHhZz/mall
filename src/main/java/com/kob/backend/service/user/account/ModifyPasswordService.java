package com.kob.backend.service.user.account;

import java.util.Map;

public interface ModifyPasswordService {
    Map<String, String> modify(String username, String oldPassword, String newPassword, String confirmedNewPassword);
}