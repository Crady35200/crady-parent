package com.crady.annotation.event;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :Crady
 * date :2020/03/22 20:24
 * desc : 测试spring事件
 **/
public class SpringEventMainConfigTest {

    @Test
    public void demo(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringEventMainConfig.class);
        context.publishEvent(new DemoEvent(" spring event ","Hello Crady !"));
    }
}