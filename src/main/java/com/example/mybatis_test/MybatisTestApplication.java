package com.example.mybatis_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//项目启动时 扫描mapper包 生成实体类
//SpringBootServletInitializer 作用 当tomcat启动时执行内置 configure 方法 将其托管给springboot
@MapperScan("com.example.mybatis_test.mapper")
//启用springCache 缓存 springCache会根据底层引入的jar决定缓存类型（如本项目引入了redis,会以redis形式缓存）
@EnableCaching
public class MybatisTestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MybatisTestApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisTestApplication.class, args);
    }
}
