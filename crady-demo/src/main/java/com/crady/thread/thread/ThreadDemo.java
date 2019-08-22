package com.crady.thread.thread;

/**
 * author:Crady
 * date:2019/08/22 20:44
 * desc: 使用Thread来实现线程
 * 优点：使用方便
 * 缺点：使用继承方式不灵活，java只支持单继承，线程不能有返回值
 **/
public class ThreadDemo extends Thread{
    public static void main(String[] args) {
            new ThreadDemo().start();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is run... Thread mode");
    }
}
