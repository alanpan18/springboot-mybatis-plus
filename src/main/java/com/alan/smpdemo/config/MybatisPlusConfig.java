package com.alan.smpdemo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author alanpan
 * @title: MybatisPlusConfig
 * @projectName springboot-mybatis-plus
 * @description: TODO mybatisplus 配置
 * @date 2019/4/1414:24
 */
@Configuration
@MapperScan("com.alan.smpdemo.mapper")
public class MybatisPlusConfig {

    /**
    * @Author alan.Pan
    * @Description //TODO plus 的性能优化
    * @Date 15:36 2019/4/14
    * @Param []
    * @return com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
    **/
    public PerformanceInterceptor performanceInterceptor()
    {
        PerformanceInterceptor performanceInterceptor
                = new PerformanceInterceptor();
        /*<!-- SQL 执行性能分析，开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长 -->*/
        performanceInterceptor.setMaxTime(1000);
        /*<!--SQL是否格式化 默认false-->*/
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    /**
    * @Author alan.Pan
    * @Description //TODO mybatis-plus分页插件
    * @Date 15:31 2019/4/14
    * @Param []
    * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
    **/
    @Bean
    public PaginationInterceptor paginationInterceptor()
    {
        PaginationInterceptor page =
                new PaginationInterceptor();
        page.setDialectType("mysql");
        return page;
    }
}
