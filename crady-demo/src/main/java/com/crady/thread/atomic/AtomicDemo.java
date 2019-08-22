package com.crady.thread.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * author:Crady
 * date:2019/1/8 10:35
 * desc:
 **/
public class AtomicDemo {

    int n = 0;
    AtomicInteger at = new AtomicInteger();
    public void incrInt(){
//        System.out.println("n=" + n);
        int cn = 10;
        CountDownLatch cd = new CountDownLatch(cn);
        CountDownLatch ed = new CountDownLatch(1);
        for (int i = 0; i < cn; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        ed.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    n += 1;
                    cd.countDown();
                }
            }).start();
        }
        try {
            ed.countDown();
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("n=" + n);
    }
    public void AtomicIncrInt(){
        int cn = 10;
        CountDownLatch cd = new CountDownLatch(cn);
//        System.out.println("at=" + at.get());
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    at.incrementAndGet();
//                    System.out.println("*******");
                    cd.countDown();
                }
            }).start();
        }
        try {
            cd.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("at=" + at.get());
    }
}
