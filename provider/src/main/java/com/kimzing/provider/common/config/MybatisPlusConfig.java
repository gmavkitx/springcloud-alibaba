package com.kimzing.provider.common.config;


import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MybatisPlus配置.
 * <p>
 *     功能开关配置
 * </p>
 *
 * @author KimZing - kimzing@163.com
 * @since 2018-08-07 02:02
 */
@EnableTransactionManagement
@Configuration
public class MybatisPlusConfig {

    /**
     * 分页插件，自动识别数据库类型.
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 查看SQL执行效率.
     * <p>
     *     参数: maxTime SQL 执行最大时长，超过自动停止运行，有助于发现问题。
     *     参数: format SQL SQL是否格式化，默认false。<br>
     *     开发测试环境开启
     * </p>
     * @return
     */
    @Bean
    @Profile({"dev", "test"})
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor interceptor = new PerformanceInterceptor();
        interceptor.setMaxTime(100);
        //设置为true,容易出现错行，不方便查看
        interceptor.setFormat(false);
        return interceptor;
    }

    /**
     * 乐观锁配置.
     * <p>
     *     会检测有@Version注解的属性，update时自动加一.
     * </p>
     * @return
     */
    @Bean
    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
        return new OptimisticLockerInterceptor();
    }


    /**
     * 配置自自动注入的字段.
     *
     * @param metaObjectHandler
     * @return
     */
    @Bean
    public GlobalConfig globalConfig(MyMetaObjectHandler metaObjectHandler) {
        GlobalConfig globalConfig = new GlobalConfig();
        // 设置自动注入的属性配置，当含有MyMetaObjectHandler中的字段时，会采用MyMetaObjectHandler中的值，手动设置值无效。
        globalConfig.setMetaObjectHandler(metaObjectHandler);
        return globalConfig;
    }

    /**
     * 开启逻辑删除.
     *
     * @return
     */
    @Bean
    public LogicSqlInjector logicSqlInjector() {
        return new LogicSqlInjector();
    }

}
