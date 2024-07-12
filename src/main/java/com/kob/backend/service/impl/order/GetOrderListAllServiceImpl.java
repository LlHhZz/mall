package com.kob.backend.service.impl.order;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kob.backend.mapper.OrderMapper;
import com.kob.backend.mapper.ProductMapper;
import com.kob.backend.pojo.Product;
import com.kob.backend.pojo.User;
import com.kob.backend.pojo.UserOrder;
import com.kob.backend.service.impl.utils.UserDetailsImpl;
import com.kob.backend.service.user.order.GetOrderListAllService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrderListAllServiceImpl implements GetOrderListAllService {
    @Autowired
    private OrderMapper orderMapper;
    @Override
    public List<UserOrder> getList() {
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        UserDetailsImpl loginUser = (UserDetailsImpl) authenticationToken.getPrincipal();
        User user = loginUser.getUser();

        // 创建一个空的查询条件
        QueryWrapper<UserOrder> queryWrapper = new QueryWrapper<>();

        return orderMapper.selectList(queryWrapper.orderByAsc("id"));
    }
}
