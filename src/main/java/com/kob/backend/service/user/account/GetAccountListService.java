package com.kob.backend.service.user.account;

import com.kob.backend.pojo.Author;
import com.kob.backend.pojo.User;

import java.util.List;

public interface GetAccountListService {
    List<User> getList();
}
