package com.crady.proxydesign;

import org.junit.Test;

/**
 * author:Crady
 * date:2019/1/15 11:32
 * desc:
 **/
public class ProxyDesignTest {

    @Test
    public void testDynaticProxyDesign(){
        Person teacher = new Teacher();
        Person proxyInstance = (Person) new DynamicProxyFactory(teacher).getProxyInstance();
        System.out.println(proxyInstance.getClass());
        proxyInstance.say("Hi,nice to meet you !");
    }

    @Test
    public void testStaticProxyDesign(){
        Teacher teacher = new Teacher();
        StaticProxyFactory staticProxyFactory = new StaticProxyFactory(teacher);
        staticProxyFactory.say("Hi,nice to meet you !");
    }
    @Test
    public void testCglibDynaticProxyDesign(){
        UserService userService = new UserService();
        UserService proxyFactory = (UserService) new CglibDynaticProxyFactory(userService).getInstance(userService);
        proxyFactory.say("Hi,nice to meet you !");
    }
}