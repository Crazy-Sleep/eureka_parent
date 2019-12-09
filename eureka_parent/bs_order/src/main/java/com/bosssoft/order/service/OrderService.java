package com.bosssoft.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.bosssoft.order.pojo.OrderPojo;

import java.util.List;

public interface OrderService extends IService<OrderPojo> {

    /**
     * 根据用户Id获取订单信息
     * @param userId
     * @return 订单列表
     */
    List<OrderPojo> getOrderByUserId(Integer userId);
}
