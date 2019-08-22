package com.crady.thread.deadlock;

import java.util.concurrent.TimeUnit;

/**
 * @author :Crady
 * date :2019/8/22 10:15
 * desc : 使用Synchronized模拟死锁
 **/
public class DeadLock1 {

    private static Object a = new Object();
    private static Object b = new Object();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (a){
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (b){
                    System.out.println("1");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (b){
                synchronized (a){
                    System.out.println("2");
                }
            }
        });

        t1.start();
        t2.start();
    }

}
