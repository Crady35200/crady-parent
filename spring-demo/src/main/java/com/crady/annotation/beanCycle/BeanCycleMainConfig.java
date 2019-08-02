package com.crady.annotation.beanCycle;

import com.crady.annotation.beanCycle.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

/**
 * author:Crady
 * date:2019/08/01 23:20
 * desc:
 **/
@Configuration
@ComponentScan("com.crady.annotation.beanCycle")
@Slf4j
public class BeanCycleMainConfig {

/*    @Bean
    public MyBeanPostProcessor myProcessor(){
        return new MyBeanPostProcessor();
    }*/

    @Bean(initMethod = "init",destroyMethod = "beanDestroy")
    @Lazy
    public User user(){
        log.info("**********即将把user加入容器*****************");
        return new User();
    }

}
