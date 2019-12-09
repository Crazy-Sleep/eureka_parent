package com.bosssoft.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication //声明springboot应用启动main
@EnableConfigServer //声明是configserver
@EnableEurekaClient //注册config服务到eureka
public class ConfigStart {

    public static void main(String[] args) {
        SpringApplication.run(ConfigStart.class, args);
    }
}
