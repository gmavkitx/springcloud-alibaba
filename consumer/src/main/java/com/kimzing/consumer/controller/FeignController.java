package com.kimzing.consumer.controller;

import com.kimzing.consumer.client.ProviderClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 使用feign进行负载调用.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019-01-03 03:56
 */
@RestController
@RequestMapping("/feign")
public class FeignController {

    @Resource
    ProviderClient providerClient;

    @GetMapping("/msg/{message}")
    public String getProviderMessage(@PathVariable String message) {
        return providerClient.provider(message);
    }

}
