package com.kob.backend.service.impl.user.account;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import com.kob.backend.service.user.account.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public Map<String, String> register(String username, String password, String confirmedPassword, String photo, String email, String birthdate) {
        Map<String, String> map = new HashMap<>();
        if(username == null) {
            map.put("error_message", "用户名不能为空");
            return map;
        }
        if(password == null || confirmedPassword == null) {
            map.put("error_message", "密码不能为空");
            return map;
        }

        username = username.trim();  // 去除首位空格
        if(username.length() == 0) {
            map.put("error_message", "用户名不能为空");
        }

        if(password.length() == 0 || confirmedPassword.length() == 0) {
            map.put("error_message", "密码不能为空");
        }

        if(username.length() > 100) {
            map.put("error_message", "用户名长度不能大于100");
            return map;
        }

        if(password.length() > 100 || confirmedPassword.length() > 100) {
            map.put("error_message", "密码长度不能大于100");
            return map;
        }

        if(!password.equals(confirmedPassword)) {
            map.put("error_message", "两次输入的密码不一致");
            return map;
        }

        // 查看数据库中是否已存在该用户名对应的用户 若已存在 提示用户名已存在
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        List<User> users = userMapper.selectList(queryWrapper);
        if(!users.isEmpty()) {
            map.put("error_message", "用户名已存在");
            return map;
        }

        // 加密密码后 存入数据库
        String encodefPassword = passwordEncoder.encode(password);
        // 已设置id自增 无需传入
        User user = new User(null, username, encodefPassword, photo, email, birthdate);
        userMapper.insert(user);

        map.put("error_message", "success");
        return map;
    }
}
