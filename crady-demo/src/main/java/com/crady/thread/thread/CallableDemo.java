package com.crady.thread.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * author:Crady
 * date:2019/08/22 20:50
 * desc:使用Callable创建线程
 * 优点：通过接口创建，可以有返回值,执行过程中无法抛异常
 * 缺点：创建相比Thread和Runnable稍显复杂
 **/
public class CallableDemo implements Callable<String> {
    @Override
    public String call() throws Exception {
        String s = Thread.currentThread().getName() + " is run... Callable mode";
        System.out.println(s);
        return s;
    }

    public static void main(String[] args) {
        FutureTask futureTask = new FutureTask<>(new CallableDemo());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
