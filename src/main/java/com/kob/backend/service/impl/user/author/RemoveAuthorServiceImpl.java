package com.kob.backend.service.impl.user.author;

import com.kob.backend.mapper.AuthorMapper;
import com.kob.backend.pojo.Author;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.author.RemoveAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.TinyBitSet;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RemoveAuthorServiceImpl implements RemoveAuthorService {
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public Map<String, String> remove(Map<String, String> data) {
        // 取得用户信息
        UsernamePasswordAuthenticationToken authentication =
                (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authentication.getPrincipal();
        User user = loginUser.getUser();

        // 根据id删除
        int author_id = Integer.parseInt(data.get("author_id"));
        authorMapper.deleteById(author_id);

        Map<String, String> map = new HashMap<>();
        map.put("error_message", "success");

        return map;
    }
}
