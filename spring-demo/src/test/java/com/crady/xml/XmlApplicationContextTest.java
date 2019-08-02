package com.crady.xml;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * author:Crady
 * date:2019/08/01 23:11
 * desc:
 **/
@Slf4j
public class XmlApplicationContextTest {
    @Test
    public void xmlApplicationContext(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-context.xml");
        log.info("***********容器初始化完成*****************");
        Object cat = applicationContext.getBean("cat");
        log.info("*************xmlApplicationContext********{}",cat);
        applicationContext.close();
    }
}