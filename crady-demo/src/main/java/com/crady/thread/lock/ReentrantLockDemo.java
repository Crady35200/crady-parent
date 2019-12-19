package com.crady.thread.lock;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :Crady
 * date :2019/12/19 10:42
 * desc : 重入锁
 **/
public class ReentrantLockDemo {

    int m,n;
    ReentrantLock lock = new ReentrantLock();
    ExecutorService executor = Executors.newFixedThreadPool(20);
    CountDownLatch cd = new CountDownLatch(20);

    public static void main(String []args) throws InterruptedException {
        ReentrantLockDemo d = new ReentrantLockDemo();
        d.exe();
//        d.exe2();
        d.cd.await();
        System.out.println("线程安全，m=" + d.m);
//        System.out.println(线程不安全，"n=" + d.n);
        d.executor.shutdown();
    }

    /**
     * 线程不安全
     */
    private void exe2() {
        for (int i = 0; i < 20; i++) {
            executor.execute(() ->{
                for (int j = 0; j < 1000; j++) {
                    n++;
                }
                cd.countDown();
            });
        }
    }

    /**
     * 线程安全
     */
    private void exe() {
        for (int i = 0; i < 20; i++) {
            executor.execute(() ->{
                for (int j = 0; j < 1000; j++) {
                    lock.lock();
                    try {
                        m++;
                    }finally {
                        lock.unlock();
                    }
                }
                cd.countDown();
            });
        }
    }
}
