package com.crady.proxydesign.dynamicProxy;

import com.crady.proxydesign.IPerson;
import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * author:Crady
 * date:2019/1/15 11:28
 * desc:jdk实现-动态代理  仅适用于目标类需要实现指定接口
 * 代理对象不需要实现接口(可以实现或者不实现),但是目标对象一定要实现接口,否则不能用动态代理
 * 动态代理有以下特点:
 * 1.代理对象,不需要实现接口
 * 2.代理对象的生成,是利用JDK的API,动态的在内存中构建代理对象(需要我们指定创建代理对象/目标对象实现的接口的类型)
 * 3.动态代理也叫做:JDK代理,接口代理
 **/
@Slf4j
public class JdkDynamicProxyFactory implements InvocationHandler {

    private Object target;

    public JdkDynamicProxyFactory(IPerson target) {
        this.target = target;
    }
    public Object getProxyInstance(){
        Object p = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        return p;

        //代理列不实现接口方式
/*        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                log.info("jdk dynatic invoke start ...");
                method.invoke(target,args);
                log.info("jdk dynatic invoke end ...");
                return null;
            }
        });*/
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log.info("jdk dynatic invoke start ...");
        method.invoke(this.target,args);
        log.info("jdk dynatic invoke end ...");
        return null;
    }
}
