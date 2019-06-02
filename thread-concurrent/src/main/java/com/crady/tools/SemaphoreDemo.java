package com.crady.tools;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * author:Crady
 * date:2019/04/20 15:18
 * desc:Semaphore可以控制线程的并发量
 **/
@Slf4j
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(2);
    ExecutorService executorService = Executors.newCachedThreadPool();
    public static final int N = 10;
    public void demo(){
        for (int i = 0; i < N; i++) {
            executorService.execute(()-> {
                try {
                    semaphore.acquire();
                    Thread.sleep(2000);
                    log.info(Thread.currentThread().getName() + " run");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

    public static void main(String[] args) {
        new SemaphoreDemo().demo();
    }
}

