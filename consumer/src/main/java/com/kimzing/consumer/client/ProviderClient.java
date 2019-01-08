package com.kimzing.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * provider的feign调用接口.
 *
 * <p>
 *     TODO sentinel完全支持feign的注解属性
 * </p>
 * @author KimZing - kimzing@163.com
 * @since 2019-01-03 04:03
 */
@FeignClient(name = "provider", path = "provider/provider", fallback = ProviderFallback.class)
public interface ProviderClient {

    @GetMapping("/msg/{message}")
    String provider(@PathVariable(value = "message") String message);

}
