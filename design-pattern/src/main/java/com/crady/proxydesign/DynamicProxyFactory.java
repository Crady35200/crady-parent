package com.crady.proxydesign;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author:Crady
 * date:2019/1/15 11:28
 * desc:jdk实现-动态代理  仅适用于目标类需要实现制定接口
 **/
public class DynamicProxyFactory implements InvocationHandler {

    private Person person;

    public DynamicProxyFactory(Person person) {
        this.person = person;
    }
    public Person getProxyInstance(){
        Person p = (Person) Proxy.newProxyInstance(person.getClass().getClassLoader(),person.getClass().getInterfaces(),this);
        return p;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("dynatic invoke start ...");
        method.invoke(this.person,args);
        System.out.println("dynatic invoke end ...");
        return null;
    }
}
