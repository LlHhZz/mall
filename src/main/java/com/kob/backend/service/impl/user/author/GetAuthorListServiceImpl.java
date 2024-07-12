package com.kob.backend.service.impl.user.author;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.AuthorMapper;
import com.kob.backend.pojo.Author;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.author.GetAuthorListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAuthorListServiceImpl implements GetAuthorListService {
    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public List<Author> getList() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        // 创建一个空的查询条件
        QueryWrapper<Author> queryWrapper = new QueryWrapper<>();

        return authorMapper.selectList(queryWrapper.orderByAsc("id"));
    }
}
