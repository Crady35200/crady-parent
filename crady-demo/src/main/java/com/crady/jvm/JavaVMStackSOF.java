package com.crady.jvm;

/**
 * @author :Crady
 * date :2019/7/19 14:46
 * desc : 模拟栈SOF
 * VM Args:-Xss128k
 **/
public class JavaVMStackSOF {

    private static int stackLenth = 1;
    public static void stackLeak(){
        stackLenth ++;
        Object [] objects = new Object[10240];
        stackLeak();
    }

    public static void main(String[] args) {
        try {
            stackLeak();
        } catch (Throwable e) {
            System.out.println("*************************stacklenth:" + stackLenth);
//            e.printStackTrace();
            throw e;
        }
    }
}
