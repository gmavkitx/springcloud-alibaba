package com.kimzing.gateway.route;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * .
 *
 * @author KimZing - kimzing@163.com
 * @since 2019-01-18 16:42
 */
public class GatewayPredicateDefinition {
    //断言对应的Name
    private String name;
    //配置的断言规则
    private Map<String, String> args = new LinkedHashMap<>();
    //此处省略Get和Set方法
}
