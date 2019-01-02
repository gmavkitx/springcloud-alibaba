package com.kimzing.consumer.client;

import org.springframework.stereotype.Component;

/**
 * provider的回退类.
 *
 * @author KimZing - kimzing@163.com
 * @since 2019-01-03 05:02
 */
@Component
public class ProviderFallback implements ProviderClient {

    @Override
    public String provider(String message) {
        return "默认回退值";
    }
}
