package com.bosssoft.order.controller;

import com.bosssoft.order.pojo.OrderPojo;
import com.bosssoft.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags = "订单服务")
@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 根据用户Id获取订单信息
     * @param userId
     * @return
     */
    @ApiOperation(value = "根据用户Id获取订单信息", httpMethod = "GET", notes = "根据用户Id获取订单信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer", paramType = "query")
    @GetMapping("/getOrderByUserId")
    public Object getOrderByUserId(Integer userId) {
        List<OrderPojo> orderList = orderService.getOrderByUserId(userId);
        return orderList;
    }

    /**
     * 根据订单ID获取订单信息
     * @param orderId
     * @return
     */
    @ApiOperation(value = "获取订单信息", httpMethod = "GET", notes = "获取订单信息")
    @ApiImplicitParams(
            @ApiImplicitParam(name="orderId", value = "订单编号", required = true, dataType = "Integer", paramType = "path")
    )
    @GetMapping("/findOrderById/{orderId}")
    public OrderPojo findOrderById(@PathVariable Integer orderId) {
        return orderService.getById(orderId);
    }
}
