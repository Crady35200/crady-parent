package com.crady.annotation.assignValue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * author:Crady
 * date:2019/08/03 10:29
 * desc: bean赋值一共有3中方式：
 * 1、通过@Value在Bean属性上赋值。
 *     @Value("Crady")
 *     private String name;
 * 2、通过EL表达式赋值。
 *     @Value("#{30-2}")
 *     private int age;
 * 3、通过@PropertySource("classpath:beanValue.properties")在主配置类上配置，然后再Bean上使用@Value。
 *    @PropertySource("classpath:beanValue.properties")
 *    public class AssignValueMainConfig
 *
 *     @Value("${crady.addr}")
 *     private String addr;
 **/
public class AssignValueMainConfigTest {

    @Test
    public void assignValueTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AssignValueMainConfig.class);
        Object crady = context.getBean("crady");
        System.out.println("********************" + crady);
    }

}