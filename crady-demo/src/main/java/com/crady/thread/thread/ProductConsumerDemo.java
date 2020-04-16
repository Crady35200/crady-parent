package com.crady.thread.thread;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author :Crady
 * date :2020/04/16 02:13
 * desc : 生产者消费者模型两种方式实现：
 * 1、基于Object的wait,notify/notifyAll
 * 2、基于Lock,Condition的await,signal/signalAll
 **/
public class ProductConsumerDemo {

    private static final int SIZE = 10;

    private static volatile ArrayList<Integer> list = new ArrayList<>(SIZE);

    private static volatile boolean flag = true;

    private static ReentrantLock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        test1();
//        test2();

    }

    public static void test1(){
        new Consumer("consumer-1").start();
        new Consumer("consumer-2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Product("product-1").start();
        new Product("product-2").start();
    }
    public static void test2(){
        new Consumer1("consumer-1").start();
        new Consumer1("consumer-2").start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Product1("product-1").start();
        new Product1("product-2").start();
    }

    static class Product extends Thread{
        String name;

        public Product(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(flag){
                synchronized (list){
                    try {
                        while(list.size() == SIZE) {
                            System.out.println(this.name + " wait begin");
                            list.wait();
                            System.out.println(this.name + " wait end");
                        }
                        list.add(new Random().nextInt(100));
//                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("[" + this.name + "]添加了一个元素---list size=" + list.size());
                        list.notifyAll();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Consumer extends Thread{
        String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(flag){
                synchronized (list){
                    try {
                        while(list.size() == 0) {
                            System.out.println(this.name + " wait begin");
                            list.wait();
                            System.out.println(this.name + " wait end");
                        }
                        list.remove(0);
//                        TimeUnit.SECONDS.sleep(2);
                        System.out.println("[" + this.name + "]移除了一个元素---list size=" + list.size());
                        list.notifyAll();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    static class Product1 extends Thread{
        String name;
        public Product1(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(flag){
                lock.lock();
                try {
                    while(list.size() == SIZE){
                        System.out.println(this.name + " await begin");
                        condition.await();
                        System.out.println(this.name + " await end");
                    }
                    list.add(new Random().nextInt(100));
//                        TimeUnit.SECONDS.sleep(2);
                    System.out.println("[" + this.name + "]添加了一个元素---list size=" + list.size());
                    condition.signalAll();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

            }
        }
    }

    static class Consumer1 extends Thread{
        String name;

        public Consumer1(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            while(flag){
                lock.lock();
                try {
                    while(list.size() == 0) {
                        System.out.println(this.name + " await begin");
                        condition.await();
                        System.out.println(this.name + " await end");
                    }
                    list.remove(0);
//                        TimeUnit.SECONDS.sleep(2);
                    System.out.println("[" + this.name + "]移除了一个元素---list size=" + list.size());
                    condition.signalAll();

                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}
