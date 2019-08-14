package com.crady.annotation.aop;

import com.crady.annotation.aop.aspect.MyAspect;
import com.crady.annotation.aop.service.DemoService;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author :Crady
 * date :2019/8/12 11:44
 * desc :
 **/
@Configuration
@ComponentScan("com.crady.annotation.aop")
@EnableAspectJAutoProxy
public class AopMainConfig {

/*    @Bean
    public DemoService demoService(){
        return new DemoService();
    }

    @Bean
    public MyAspect myAspect(){
        return new MyAspect();
    }*/
}
