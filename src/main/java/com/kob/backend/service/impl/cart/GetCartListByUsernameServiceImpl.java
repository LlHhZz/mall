package com.kob.backend.service.impl.cart;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.CartMapper;
import com.kob.backend.pojo.Cart;
import com.kob.backend.pojo.User;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.cart.GetCartListByUsernameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Service
public class GetCartListByUsernameServiceImpl implements GetCartListByUsernameService {
    @Autowired
    private CartMapper cartMapper;

    @Override
    public List<Cart> getListByUsername(String username) {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        // 创建一个空的查询条件
        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        queryWrapper.orderByAsc("id");

        List<Cart> cartList = cartMapper.selectList(queryWrapper);

        return cartList;
    }
}