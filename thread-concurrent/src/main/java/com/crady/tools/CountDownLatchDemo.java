package com.crady.tools;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * author:Crady
 * date:2019/04/20 15:09
 * desc: CountDownLatch可以控制线程的执行顺序
 **/
@Slf4j
public class CountDownLatchDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(2);
    public void demo(){
       new Thread(new Runnable() {
           @Override
           public void run() {
               log.info("thread-1 run");
               countDownLatch.countDown();
           }
       },"thread-1").start();
       new Thread(new Runnable() {
           @Override
           public void run() {
               log.info("thread-2 run");
               countDownLatch.countDown();
           }
       },"thread-2").start();
    }
    public static void main(String[] args) throws Exception{
        new CountDownLatchDemo().demo();
        countDownLatch.await();//等待thread-1和thread-2两个线程执行完成再执行
        log.info("thread-main run");
    }
}
