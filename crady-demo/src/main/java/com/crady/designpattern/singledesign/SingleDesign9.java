package com.crady.designpattern.singledesign;

/**
 * author:Crady
 * date:2019/1/4 15:13
 * desc: 懒汉模式-枚举实现(推荐使用)
 * 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象。
 * 可能是因为枚举在JDK1.5中才添加，所以在实际项目开发中，很少见人这么写过
 * 优点：在避免了线程不安全，延迟加载，效率高
 * 缺点：
 **/
public class SingleDesign9 {

    private SingleDesign9(){

    }
    public static SingleDesign9 getInstance(){
        return InnerEnue.INSTANCE.getInstance();
    }

    private enum InnerEnue{
        INSTANCE;
        private SingleDesign9 singleDesign9 = null;
        //JVM保证类的构造方法只会被调用一次
        InnerEnue(){
            singleDesign9 = new SingleDesign9();
        }
        public SingleDesign9 getInstance(){
            return singleDesign9;
        }

    }
    public void hello(){
        System.out.println("I am a enum single design.");
    }
}
