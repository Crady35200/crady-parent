package com.crady.annotation.beanCycle;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author:Crady
 * date:2019/08/01 23:22
 * desc: spring事件
 **/
@Slf4j
public class BeanCycleMainConfigTest {

    @Test
    public void beanCircleTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanCycleMainConfig.class);

        System.out.println("***************容器初始化完成*********************");
        Object user = context.getBean("user");
        System.out.println("*****************" + user);
/*        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for(String beanName : beanDefinitionNames){
            System.out.println("*********" + beanName + "******" + context.getBean(beanName));
        }*/
        context.close();
    }

}