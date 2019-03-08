package com.crady.singledesign;

/**
 * author:Crady
 * date:2019/1/4 15:13
 * desc: 懒汉模式-枚举实现(推荐使用)
 * 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 * 可能是因为枚举在JDK1.5中才添加，所以在实际项目开发中，很少见人这么写过
 * 优点：在避免了线程不安全，延迟加载，效率高
 * 缺点：使用synchronized实现了同步，但是性能低下
 **/
public enum  SingleDesign8 {

    INSTANCE;
    public void hello(){
        System.out.println("I am a enum single design.");
    }
}
