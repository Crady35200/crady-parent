package com.crady.annotation.aop;

import com.crady.annotation.aop.service.DemoService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :Crady
 * date :2019/8/12 12:09
 * desc :  注意  1、打开around环绕通知时，如果程序有异常不会执行afterThrowing方法。
 *               2、此时的顺序为  around before>before>目标方法>around after >after>afterReturning。
 *               3、around通知很强大，但容易出错，如果没有必要尽量使用其他通知。
 **/
public class AopMainConfigTest {

    @Test
    public void aopMainConfigTest(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopMainConfig.class);
        DemoService demoService = (DemoService) context.getBean("demoService");
        demoService.hello();

    }
}