package com.bosssoft.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient // 开启客户端注解
@EnableFeignClients // 开启服务之间调用  采用feign
public class TestStart {

    public static void main(String[] args) {
        SpringApplication.run(TestStart.class, args);
    }

}
