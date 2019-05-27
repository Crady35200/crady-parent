package com.crady.beanCircle;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author :Crady
 * date :2019/5/27 14:08
 * desc :
 **/
@Configuration
@ComponentScans({@ComponentScan("com.crady.beanCircle"),@ComponentScan("com.crady.bean")})
public class BeanCircleMain {

}
