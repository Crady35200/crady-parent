package com.crady.beanCircle;

import com.crady.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :Crady
 * date :2019/5/27 14:15
 * desc :
 **/
@Slf4j
public class BeanCircleMainTest {

    @Test
    public void beanCircleDemo(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(BeanCircleMain.class);
        User user = (User) applicationContext.getBean("user");
        log.info("user={}",user);
    }
}