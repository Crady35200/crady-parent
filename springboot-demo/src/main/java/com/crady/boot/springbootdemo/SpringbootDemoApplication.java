package com.crady.boot.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@ServletComponentScan(basePackages = "com.crady.boot.springbootdemo.filter")
public class SpringbootDemoApplication implements WebMvcConfigurer {

    @Autowired
    private HandlerInterceptor demoInterceptor;
    @Autowired
    private HandlerInterceptor aInterceptor;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(aInterceptor).addPathPatterns("/**");
        registry.addInterceptor(demoInterceptor).addPathPatterns("/**");
    }

}

