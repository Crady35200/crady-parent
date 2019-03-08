package com.crady.singledesign;

/**
 * author:Crady
 * date:2019/1/4 15:13
 * desc: 饥汉模式-静态代码块初始化(可用)
 * 优点：在类装载时实例化，避免线程同步问题
 * 缺点：没有实现lazy loading 如果很久时间没有使用会造成内存浪费
 **/
public class SingleDesign2 {

    private static SingleDesign2 single = null;
    static {
        single = new SingleDesign2();
    }

    private SingleDesign2() {
    }

    public static SingleDesign2 getSingleDesign1(){
        return single;
    }
}
