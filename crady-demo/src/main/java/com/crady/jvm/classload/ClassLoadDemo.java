package com.crady.jvm.classload;

/**
 * author:Crady
 * date:2019/09/04 23:06
 * desc: 类的加载顺序
 * 父类静态数据>子类静态数据>父类的成员数据>父类构造方法>子类的成员数据>子类构造方法
 **/
public class ClassLoadDemo {
    public static void main(String[] args) {
        Son son = new Son();
    }
}
