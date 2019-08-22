package com.crady.thread.thread;

/**
 * author:Crady
 * date:2019/08/22 20:47
 * desc:使用Runnable实现线程
 * 优点：使用方便，且灵活
 * 缺点：线程不能有返回值,执行过程中无法抛异常
 **/
public class RunnableDemo implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is run... Runnable mode");
    }

    public static void main(String[] args) {
        new Thread(new RunnableDemo()).start();
    }
}
