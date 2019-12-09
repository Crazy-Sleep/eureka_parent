package com.bosssoft.order.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bosssoft.order.mapper.OrderMapper;
import com.bosssoft.order.pojo.OrderPojo;
import com.bosssoft.order.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, OrderPojo> implements OrderService {

    /**
     * 根据用户Id获取订单信息
     * @param userId
     * @return 订单列表
     */
    @Override
    public List<OrderPojo> getOrderByUserId(Integer userId) {
        //构建查询条件
        QueryWrapper<OrderPojo> orderQueryWrapper = new QueryWrapper<>();
        orderQueryWrapper.eq("user_id", userId);
        return this.list(orderQueryWrapper);
    }
}
