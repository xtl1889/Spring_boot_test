package com.example.mybatis_test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//项目启动时 扫描mapper包 生成实体类
//SpringBootServletInitializer 作用 当tomcat启动时执行内置 configure 方法 将其托管给springboot
@MapperScan("com.example.mybatis_test.mapper")
public class MybatisTestApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(MybatisTestApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(MybatisTestApplication.class, args);
    }
}
