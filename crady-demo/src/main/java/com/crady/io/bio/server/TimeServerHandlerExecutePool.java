package com.crady.io.bio.server;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * author:Crady
 * date:2019/10/18 00:25
 * desc:
 **/
public class TimeServerHandlerExecutePool {

    private ExecutorService executor;

    public TimeServerHandlerExecutePool(int maxPoolSize,int queueSize) {
        executor = new ThreadPoolExecutor(
                Runtime.getRuntime().availableProcessors(),maxPoolSize,
                60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(queueSize));
    }
    public void execute(Runnable task){
        executor.execute(task);
    }
}
