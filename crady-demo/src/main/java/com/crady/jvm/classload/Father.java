package com.crady.jvm.classload;

/**
 * author:Crady
 * date:2019/09/04 22:56
 * desc:
 **/
public class Father {
    //静态变量
    public static String fs = getMsg("father static value");
    //成员变量
    public String fns = getMsg("father nostatic value");
    //静态代码块
    static {
        System.out.println("father staic block");
    }
    //普通代码块
    {
        System.out.println("father nostaic block");
    }
    //构造方法
    public Father(){
        System.out.println("father construct");
    }

    public static String getMsg(String num){
        System.out.println(num);
        return num;
    }
}
