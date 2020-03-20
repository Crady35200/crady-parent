package com.crady.thread.thread;

import java.util.concurrent.*;

/**
 * @author :Crady
 * date :2020/03/20 22:59
 * desc : 用于异步执行耗时任务然后放回主线程
 **/
public class CompletableFutureDemo {

    public Future<Integer> doSth(int n){
        CompletableFuture<Integer> result = new CompletableFuture<>();
        new Thread(() -> {//异步执行耗时任务
            try {
//                int i = 1/0; //模拟出错
                result.complete(dos(n));
            } catch (Exception e) {
                e.printStackTrace();
                //需要设置不然调用线程不知道具体错误信息
                result.completeExceptionally(e);
            }
        }).start();
        return result;
    }

    public int dos(Integer n){
        int sum = 0;
        try {
            for (int i = 1; i <= n; i++) {
                sum += i;
            }
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum;

    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Future<Integer> result = new CompletableFutureDemo().doSth(100);
        //调用完后可以马上获得一个Future对象，可以继续执行其他任务
        System.out.println("after call:" + (System.currentTimeMillis() - start) + "ms");
        try {
            //阻塞获取任务,最好设置过期时间以防止异步出错死等
            Integer integer = null;
            integer = result.get(5, TimeUnit.SECONDS);
            System.out.println("result= " + integer);
            System.out.println("after get result:" + (System.currentTimeMillis() - start) + "ms");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }
}
