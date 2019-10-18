package com.crady.designpattern.singledesign;

/**
 * author:Crady
 * date:2019/1/4 15:13
 * desc: 懒汉模式-静态内部类实现(推荐使用)
 * 这种方式跟饿汉式方式采用的机制类似，但又有不同。两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
 * 不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，没有Lazy-Loading的作用，
 * 而静态内部类方式在Singleton类被装载时并不会立即实例化，而是在需要实例化时，调用getInstance方法，
 * 才会装载SingletonInstance类，从而完成Singleton的实例化。
 * 优点：在避免了线程不安全，延迟加载，效率高
 * 由于在调用 SingletonHolder.instance 的时候，才会对单例进行初始化，而且通过反射，
 * 是不能从外部类获取内部类的属性的。 所以这种形式，很好的避免了反射入侵。
 * 缺点：需要两个类去做到这一点，虽然不会创建静态内部类的对象，但是其 Class 对象还是会被创建，而且是属于永久代的对象。
 **/
public class SingleDesign7 {

    private SingleDesign7() {
    }

    private static class SingleInstance {
        private static final SingleDesign7 INSTANCE = new SingleDesign7();
    }

    public static SingleDesign7 getSingleDesign1() {
        return SingleInstance.INSTANCE;
    }
}
