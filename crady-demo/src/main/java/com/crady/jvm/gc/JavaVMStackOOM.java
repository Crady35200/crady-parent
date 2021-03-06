package com.crady.jvm.gc;

/**
 * @author :Crady
 * date :2019/7/19 15:11
 * desc : 模拟栈内存溢出 OOM(小心运行可能导致电脑死机)
 * VM Args : -Xss5m
 **/
public class JavaVMStackOOM {

    private static int threads = 1;

    private static void dontStop(){
        while(true){

        }
    }

    public static void main(String[] args) {
        try {
            while(true){
                threads ++;
                System.out.println("==========" + threads);
                new Thread(()->dontStop()).start();
            }
        } catch (Throwable e) {
            System.out.println("*********************************threads:" + threads);
            e.printStackTrace();
        }finally {
            System.out.println("finally******************");
        }
    }
}
