package com.crady.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * author:Crady
 * date:2019/3/28 10:12
 * desc:
 **/
public class ConditionTest implements Runnable {

    static Lock lock = new ReentrantLock();

    static Condition condition = lock.newCondition();


    @Override
    public void run() {
        try {
            lock.lock();
            // 该线程会释放 lock 的锁，也就是说，一个线程想调用 condition 的方法，必须先获取 lock 的锁。
            // 否则就会像 object 的 wait 方法一样，监视器异常
            //该处会释放锁
            condition.await();
            System.out.println("Thread is going on");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionTest t = new ConditionTest();
        Thread t1 = new Thread(t);
        t1.start();
        Thread.sleep(1000);
        // 通知 t1 继续执行
        // main 线程必须获取 lock 的锁，才能调用 condition 的方法。否则就是监视器异常，这点和 object 的 wait 方法是一样的。
        lock.lock(); // IllegalMonitorStateException
        // 从 condition 的等待队列中，唤醒一个线程。
        condition.signal();
        lock.unlock();
    }
}
