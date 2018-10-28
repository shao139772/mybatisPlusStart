package com.miaomiao.bootwithmybatisplus.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by cw on 2018/10/28.
 */
@Configuration
@MapperScan(basePackages = {"com.miaomiao.bootwithmybatisplus.sys.mapper*"})
public class MybatisConfiguration {

    /**
     * 分页插件，自动识别数据库类型
     * 多租户，请参考官网【插件扩展】
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
