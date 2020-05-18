package com.crady.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author :Crady
 * date :2020/05/18 23:18
 * desc :
 **/
public class ThreadPoolDemo {

    ThreadPoolExecutor executorService;

    public static void main(String[] args) throws InterruptedException {
        ThreadPoolDemo demo = new ThreadPoolDemo();
        demo.initThreadPool();
        demo.doWork();
        TimeUnit.SECONDS.sleep(3);
        System.out.println("***************************************");
        demo.printTheadPoolStatus();
    }

    private void doWork() {
        for (int i = 0; i < 5; i++) {
            int finalI = i;
            executorService.submit(() ->{
                printTheadPoolStatus();
                try {
                    TimeUnit.SECONDS.sleep(1);
                    if(finalI == 3){
                        int t = 1 / 0;
//                        throw new RuntimeException("模拟报错");
                    }
                    System.out.println(" do work " + finalI);
                } catch (Exception e) {
                    e.printStackTrace();
                }finally {
//                    System.out.println("exception");
                    printTheadPoolStatus();
                }
            });
        }
    }

    public void initThreadPool(){
        executorService = new ThreadPoolExecutor(5,
                5,0L,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1000));
    }

    public void printTheadPoolStatus(){
        int active = executorService.getActiveCount();
        int n = executorService.getPoolSize();
        System.out.println("active thread = " + active + ",poolSize=" +n);
    }


}
