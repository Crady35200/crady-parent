package com.crady.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author :Crady
 * date :2019/12/19 11:41
 * desc : 使用RateLimiter限流
 **/
public class RateLimiterDemo {
    static RateLimiter limiter = RateLimiter.create(5);
    static ExecutorService es = Executors.newCachedThreadPool();
    static CountDownLatch cd = new CountDownLatch(50);

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 50; i++) {
            es.execute(() ->{
                limiter.acquire();
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(LocalDateTime.now() + ">limit ....");
                cd.countDown();
            });
        }
        cd.await();
        es.shutdown();
        System.out.println("执行完成");
    }
}
