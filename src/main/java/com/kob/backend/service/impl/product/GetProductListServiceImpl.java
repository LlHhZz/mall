package com.kob.backend.service.impl.product;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.ProductMapper;
import com.kob.backend.pojo.Product;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.product.GetProductListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductListServiceImpl implements GetProductListService {
    @Autowired
    private ProductMapper productMapper;
    @Override
    public List<Product> getList() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        // 创建一个空的查询条件
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();

        return productMapper.selectList(queryWrapper.orderByAsc("id"));
    }
}