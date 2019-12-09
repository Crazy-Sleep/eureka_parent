package com.bosssoft.user.controller;

import com.bosssoft.user.dto.OrderDto;
import com.bosssoft.user.feign.OrderClient;
import com.bosssoft.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Api(tags = "用户服务")
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private OrderClient orderClient;

    /**
     *
     * @return
     */
    //@SwaggerCustomIgnore  swagger忽略注释
    @ApiOperation(value = "获取用户列表", httpMethod = "GET", notes = "获取用户列表")
    @GetMapping("/list")
    public Object getUserList(){
        return userService.getUserList();
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

    /**
     * 熔断器的注解式实现方式 配合下面processGetOrderHystrix方法使用
     * @HystrixCommand(fallbackMethod = "processGetOrderHystrix")
     */
    public Object findOrderById(@PathVariable Integer orderId) {
        OrderDto orderPojo = orderClient.findOrderById(orderId);
        if (null == orderPojo) {
            System.out.println("数据库没有对应的信息");
            throw new RuntimeException("数据库没有对应的信息");
        }
        return orderPojo;
    }

    /**
     * 上面getOrder()方法出异常后的熔断处理方法
     * @param id id
     * @return 订单信息
     */
    public Object processGetOrderHystrix(@PathVariable Integer id) {
        return id+"未找到该ID的结果"+0d +"No this datasource";
    }


    /**
     * ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response =
     * “接口返回参数类型”, notes = “接口发布说明”
     */
    @ApiOperation(value = "测试", httpMethod = "POST", notes = "测试")
    @PostMapping("create")
    public Object creteUser(){
        return "1";
    }

    @ApiOperation(value = "根据用户Id获取订单信息", httpMethod = "GET", notes = "根据用户Id获取订单信息")
    @ApiImplicitParam(name = "userId", value = "用户ID", required = true, dataType = "Integer", paramType = "query")
    @GetMapping("/getOrderByUserId")
    public Object getOrderByUserId(Integer userId) {
        List<OrderDto> orderList = orderClient.getOrderByUserId(userId);
        return orderList;
    }


}
