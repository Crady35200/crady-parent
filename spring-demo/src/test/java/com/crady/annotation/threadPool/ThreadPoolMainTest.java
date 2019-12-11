package com.crady.annotation.threadPool;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author :Crady
 * date :2019/12/11 10:13
 * desc :
 **/
public class ThreadPoolMainTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        ApplicationContext context = new AnnotationConfigApplicationContext(ThreadPoolMain.class);
        ThreadPoolTaskExecutor threadPool = (ThreadPoolTaskExecutor) context.getBean("executor");
        System.out.println("****************main thread: " + Thread.currentThread().getId());
        threadPool.execute(() ->
            System.out.println("*******************task thread: " + Thread.currentThread().getId())
        );
        Future<?> future = threadPool.submit(() -> {
                    System.out.println("***********submit********task thread: " + Thread.currentThread().getId());
                    return "***********submit*****success";
                }
        );
        System.out.println(future.get());
        Thread.sleep(100);
        threadPool.shutdown();


    }
}