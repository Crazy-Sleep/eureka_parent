package com.bosssoft.user.controller;

import com.bosssoft.user.annotation.SwaggerCustomIgnore;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "测试")
@RestController
@RequestMapping("/user")
public class UserController {
    @SwaggerCustomIgnore
    @GetMapping("/list")
    public Object getUserList(){
        return "0";
    }

    /**
     * ApiOperation(value = “接口说明”, httpMethod = “接口请求方式”, response =
     * “接口返回参数类型”, notes = “接口发布说明”
     *
     */
    @ApiOperation(value = "测试", httpMethod = "POST", notes = "测试")
    @PostMapping("create")
    public Object creteUser(){
        return "1";
    }

}
