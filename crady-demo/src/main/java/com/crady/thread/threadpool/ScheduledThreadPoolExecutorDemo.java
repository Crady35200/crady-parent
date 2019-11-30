package com.crady.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author :Crady
 * date :2019/11/30 11:23
 * desc :
 **/
@Slf4j
public class ScheduledThreadPoolExecutorDemo {

    ScheduledExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(5);

    /**
     * 指定延时时间后执行任务
     */
    public void schedule(){
        threadPoolExecutor.schedule(()->{
            log.info("schedule...");
        },5, TimeUnit.SECONDS);
    }

    /**
     * 以固定的频率指定任务，执行间隔为上个一个任务执行开始到下一个任务开始的时间
     */
    public void scheduleAtFixedRate(){
        threadPoolExecutor.scheduleAtFixedRate(()->{
            log.info("scheduleAtFixedRate...");
        },10,5, TimeUnit.SECONDS);
        threadPoolExecutor.shutdown();
    }

    /**
     * 以固定的频率指定任务，执行间隔为上个一个任务执行完到下一个任务开始的时间
     */
    public void scheduleWithFixedDelay(){
        threadPoolExecutor.scheduleWithFixedDelay(()->{
            log.info("scheduleWithFixedDelay...");
        },10,5, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        ScheduledThreadPoolExecutorDemo demo = new ScheduledThreadPoolExecutorDemo();
//        demo.schedule();
//        demo.scheduleAtFixedRate();
        demo.scheduleWithFixedDelay();
    }



}
