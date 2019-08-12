package com.crady;

import com.crady.plugin.SlowSqlInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.PostConstruct;
import java.util.Properties;

@SpringBootApplication
@MapperScan(basePackages = "com.crady.mapper",annotationClass = Repository.class)
@ServletComponentScan(basePackages = "com.crady.filter")
public class SpringbootDemoApplication implements WebMvcConfigurer {

    @Autowired
    private HandlerInterceptor demoInterceptor;
    @Autowired
    private HandlerInterceptor aInterceptor;
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @PostConstruct
    public void initMybatisPlugin(){
        Interceptor plugin = new SlowSqlInterceptor();
        Properties properties = new Properties();
        properties.setProperty("threshold","500");
        plugin.setProperties(properties);
        sqlSessionFactory.getConfiguration().addInterceptor(plugin);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(aInterceptor).addPathPatterns("/**");
        registry.addInterceptor(demoInterceptor).addPathPatterns("/demo/**");
    }

}

