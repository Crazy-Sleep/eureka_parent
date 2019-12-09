package com.bosssoft.user.feign;

import com.bosssoft.user.dto.OrderDto;
import com.bosssoft.user.hystrix.OrderServiceFallBack;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "order-service", path = "/order/", fallback = OrderServiceFallBack.class)
public interface OrderClient {

    /**
     * 获取用户订单信息
     * @param userId
     * @return
     */
    @RequestMapping(value = "getOrderByUserId", method = RequestMethod.GET)
    List<OrderDto> getOrderByUserId(@RequestParam("userId") Integer userId);

    /**
     * 根据订单ID获取订单信息
     * @param orderId
     * @return
     */
    @RequestMapping(value = "/findOrderById/{orderId}", method = RequestMethod.GET)
    OrderDto findOrderById(@PathVariable("orderId") Integer orderId);
}
