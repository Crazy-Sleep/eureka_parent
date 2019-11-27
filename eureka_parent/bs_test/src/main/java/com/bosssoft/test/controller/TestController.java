package com.bosssoft.test.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/test")
public class TestController {

    @Value("${spring.application.name}")
    private String springApplicationName;

    @Value("${server.port}")
    private String serverPort;

    @Value("${eureka.client.service-url.defaultZone}")
    private String defaultEurekaZone;

    @GetMapping("/test")
    public String getConfig() {
        return "applicationName=" + springApplicationName
                + "; serverPort=" + serverPort
                + "; defaultEurekaZone=" + defaultEurekaZone;
    }

}
