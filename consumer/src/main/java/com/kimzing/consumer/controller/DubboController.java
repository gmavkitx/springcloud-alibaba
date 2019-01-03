package com.kimzing.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.kimzing.provider.service.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/1/3 17:09
 */
@RestController
@RequestMapping("/dubbo")
public class DubboController {

    @Reference
    DubboService dubboService;

    @GetMapping("/msg/{message}")
    public String dubbo(@PathVariable String message) {
       return dubboService.hello(message);
    }

}
