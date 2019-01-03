package com.kimzing.provider.service;

import com.alibaba.dubbo.config.annotation.Service;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2019/1/3 16:57
 */
@Service(interfaceClass = DubboService.class) //注册到Dubbo Registry, 同时注册到spring容器
public class DubboServiceImpl implements DubboService {
    @Override
    public String hello(String msg) {
        return "dubbo" + msg;
    }
}
