package com.kimzing.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 生产者示例接口, 供消费者调用.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019-01-03 03:43
 */
@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private Integer serverPort;

    @GetMapping("/msg/{message}")
    public String provider(@PathVariable String message) {
        return String.format("%s:%s received message: %s", applicationName, serverPort, message);
    }

}
