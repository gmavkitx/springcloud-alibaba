package com.kimzing.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 使用ribbon进行负载调用.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019-01-03 03:56
 */
@RestController
@RequestMapping("/ribbon")
public class RibbonController {

    @Resource
    RestTemplate restTemplate;

    /**
     * 请求provider接口
     *
     * <p>
     *     定义监控：@SentinelResource(value = "message")
     * </p>
     * @param message
     * @return
     */
    @SentinelResource(value = "message")
    @GetMapping("/msg/{message}")
    public String getProviderMessage(@PathVariable String message) {
        return restTemplate.getForObject("http://provider/provider/provider/msg/" + message, String.class);
    }

}
