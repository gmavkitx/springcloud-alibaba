package com.kimzing.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试动态获取nacos中配置.
 *
 * <p>
 *     dataId表达式为${prefix}-${spring.profile.active}.${file-extension}
 *     prefix: 默认为 spring.application.name 的值，可通过配置项 spring.cloud.nacos.config.prefix来配置。
 *     spring.profile.active: 当前环境对应的 profile，
 *         注意：当 spring.profile.active 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成 ${prefix}.${file-extension}
 *     file-exetension: 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置。目前支持 properties 和 yaml 类型。
 * </p>
 * @author KimZing - kimzing@163.com
 * @since 2019-01-02 22:49
 */
@RestController
/** 配置自动更新 */
@RefreshScope
@RequestMapping(value = "/refresh")
public class RefreshController {

    /**
     * 项目已经设置profile为dev, 新建命名空间dev并在其中建立如下相应的配置
     * <p>
     * yaml方式
     *   data id: provider-dev.yaml
     *   group: DEFAULT_GROUP
     *   配置格式: yaml
     *   内容: name: kim-yaml
     * </p>
     *
     * <p>
     * properties方式
     *   data id: provider-dev.properties
     *   group: DEFAULT_GROUP
     *   配置格式: properties
     *   内容: name=kim-properties
     * </p>
     */
    @Value("${name}")
    private String name;

    @GetMapping(value = "/name")
    public String getName() {
        return this.name;
    }

}
