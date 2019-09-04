package com.crady.jvm.classload;

/**
 * author:Crady
 * date:2019/09/04 23:03
 * desc:
 **/
public class Son extends Father {
    //静态变量
    public static String fs = getMsg("Son static value");
    //成员变量
    public String fns = getMsg("Son nostatic value");
    //静态代码块
    static {
        System.out.println("Son staic block");
    }
    //普通代码块
    {
        System.out.println("Son nostaic block");
    }
    //构造方法
    public Son(){
        System.out.println("Son construct");
    }
}
