package com.crady.annotation.aop;

import com.crady.annotation.aop.service.DemoService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :Crady
 * date :2019/8/12 12:09
 * desc :
 **/
public class AopMainConfigTest {

    @Test
    public void aopMainConfigTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopMainConfig.class);
        DemoService demoService = (DemoService) context.getBean("demoService");
        demoService.hello();

    }
}