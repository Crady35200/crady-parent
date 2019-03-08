package com.crady.proxydesign;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * author:Crady
 * date:2019/1/15 14:06
 * desc:cglib实现-动态代理  使用户需要代理的目标类不需要实现制定接口
 **/
public class CglibDynaticProxyFactory implements MethodInterceptor {

    private Object target;

    public CglibDynaticProxyFactory(Object target) {
        this.target = target;
    }

    public Object getInstance(Object target){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib dynatic invoke start ...");
        method.invoke(target,objects);
        System.out.println("cglib dynatic invoke end ...");
        return null;
    }
}
