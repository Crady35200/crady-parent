package com.crady.jvm.gc;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

/**
 * @author :Crady
 * date :2019/7/19 15:41
 * desc :
 * JVM Args : -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 **/
public class MetaspaceOOM {

    public static void main(String[] args) {
       while(true){
           Enhancer enhancer = new Enhancer();
           enhancer.setSuperclass(OOMObject.class);
           enhancer.setUseCache(false);
           enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invoke(o,objects));
           enhancer.create();
       }

    }
    static class OOMObject{}
}
