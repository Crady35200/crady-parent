package com.crady.annotation.autowired;

import com.crady.annotation.autowired.service.ServiceA;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :Crady
 * date :2020/05/14 14:51
 * desc :
 **/
public class AutowiredConfigMainTest {

    @Test
    public void autowiredTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowiredConfigMain.class);
        ServiceA serviceA = (ServiceA) context.getBean("serviceA");
        serviceA.hello();
    }
}