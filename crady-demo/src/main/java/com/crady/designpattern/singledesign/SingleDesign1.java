package com.crady.designpattern.singledesign;

/**
 * author:Crady
 * date:2019/1/4 15:13
 * desc: 饥汉模式-静态变量初始化(可用)
 * 优点：在类装载是实例化，避免线程同步问题
 * 缺点：没有实现lazy loading 如果一直没有使用或者很久时间没有使用会造成内存浪费
 **/
public class SingleDesign1 {

    private static SingleDesign1 single = new SingleDesign1();

    private SingleDesign1() {
    }
    public static SingleDesign1 getSingleDesign1(){
        return single;
    }
}
