package com.kob.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import com.kob.backend.service.user.account.ModifyPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ModifyPasswordServiceImpl implements ModifyPasswordService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, String> modify(String username, String oldPassword, String newPassword, String confirmedNewPassword) {
        Map<String, String> map = new HashMap<>();

        // 检查用户名是否为空
        if(username == null || username.trim().isEmpty()) {
            map.put("error_message", "用户名不能为空");
            return map;
        }

        // 检查旧密码、新密码以及确认新密码是否为空
        if (oldPassword == null || oldPassword.isEmpty() ||
                newPassword == null || newPassword.isEmpty() ||
                confirmedNewPassword == null || confirmedNewPassword.isEmpty()) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        // 从数据库中查询用户信息
        User user = userMapper.selectOne(new QueryWrapper<User>().eq("username", username));

        // 检查用户是否存在
        if (user == null) {
            map.put("error_message", "用户不存在");
            return map;
        }

        // 检查旧密码是否正确
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            map.put("error_message", "旧密码输入错误");
            return map;
        }

        // 检查新密码和确认新密码是否一致
        if (!newPassword.equals(confirmedNewPassword)) {
            map.put("error_message", "两次输入的新密码不一致");
            return map;
        }

        // 更新密码
        String encodedNewPassword = passwordEncoder.encode(newPassword);
        user.setPassword(encodedNewPassword);
        userMapper.updateById(user);

        map.put("error_message", "success");
        return map;
    }
}
