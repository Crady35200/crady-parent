package com.crady.thread.thread;

import java.util.concurrent.*;

/**
 * author:Crady
 * date:2019/1/8 15:31
 * desc: 使用线程池创建线程
 **/
public class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        Runnable r = () -> {
            String s =Thread.currentThread().getName() + " is run... Runable mode";
            System.out.println(s);
        };
        executorService.submit(r);

        Callable<String> c = () -> {
            String s =Thread.currentThread().getName() + " is run... Callable mode";
            System.out.println(s);
            return s;
        };
        Future<String> submit = executorService.submit(c);
        try {
            System.out.println(Thread.currentThread().getName() + " Callable:" + submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        FutureTask<String> f = new FutureTask<>(() -> {
            String s = Thread.currentThread().getName() + " is run... Future Tashk mode";
            System.out.println(s);
            return s;
        });

        try {
            System.out.println(Thread.currentThread().getName() + " Future Task:" + f.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        executorService.shutdown();
    }
}
