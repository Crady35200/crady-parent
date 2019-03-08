package com.crady.atomic;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;

/**
 * author:Crady
 * date:2019/1/8 10:40
 * desc: 并发工具  Atomic、CountDownlatch、CyclicBarrier、Semaphore、Exchanger应用
 **/
public class AtomicDemoTest {

    @Test
    public void atomicDemoTest(){
        for (int i = 0; i < 10; i++) {
            AtomicDemo ad = new AtomicDemo();
            ad.incrInt();
//              ad.AtomicIncrInt();
        }

    }

    @Test
    public void countDownLathcDemo(){

        int n = 10;
        CountDownLatch cdl = new CountDownLatch(n);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " finish");
                    cdl.countDown();
                }
            },"thread-"+i).start();
        }
        try {
            cdl.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish all:");
    }

    @Test
    public void joinDemo(){
        int n = 10;
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " finish");
                }
            },"thread-" + i);
            t.start();
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main finish");
    }

    @Test
    public void cylicBarrierDemo(){
        CyclicBarrier cb = new CyclicBarrier(2,new A());
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cb.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("sub finish");
            }
        }).start();
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("main finish");
    }
    class A extends Thread{
        @Override
        public void run() {
            System.out.println("a finish");
        }
    }

    @Test
    public void exchangerDemo(){
        Exchanger<String> ex = new Exchanger<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String a = "a-crady";
                try {
                    String s = ex.exchange(a);
                    System.out.println("a=" + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                String b = "b-ming";
                try {
                    String s = ex.exchange(b);
                    System.out.println("b=" + s);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

}