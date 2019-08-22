package com.crady.thread.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author:Crady
 * date:2019/1/8 15:31
 * desc:
 **/
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(()->{
            String s =Thread.currentThread().getName() + " is run... Runable mode";
            System.out.println(s);
        });
        executorService.submit(()->{
            String s =Thread.currentThread().getName() + " is run... Callable mode";
            System.out.println(s);
        });

        executorService.shutdown();
    }
}
