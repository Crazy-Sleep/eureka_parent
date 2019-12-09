package com.bosssoft.user.hystrix;

import com.bosssoft.user.dto.OrderDto;
import com.bosssoft.user.feign.OrderClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderServiceFallBack implements OrderClient {

    /**
     * 获取用户订单信息
     * @param userId
     * @return
     */
    @Override
    public List<OrderDto> getOrderByUserId(Integer userId) {
        return null;
    }

    /**
     * 根据订单ID获取订单信息
     * @param orderId
     * @return
     */
    @Override
    public OrderDto findOrderById(Integer orderId) {
        return null;
    }
}
