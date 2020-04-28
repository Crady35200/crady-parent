package com.crady.annotation.transaction;

import com.crady.annotation.transaction.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author :Crady
 * date :2020/04/28 22:18
 * desc :测试用例，用于spring事务源码阅读
 **/
public class TransactionMainConfigTest {

    @Test
    public void testTransaction(){
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(TransactionMainConfig.class);
        UserService userService = (UserService) ctx.getBean("userServiceImpl");
        userService.updateUserName(4,"kafka");
    }
}