package com.crady.tools;

import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.*;

/**
 * author:Crady
 * date:2019/04/20 20:48
 * desc:CycliBarrier可以让一批任务准备好，然后执行，批量执行任务，和CountDownLatch功能一样，
 * 只不过该指标限制可以重复使用。且该指标是递增的，而CountDownLatch是递减的一次性
 * 使用的
 **/
@Slf4j
public class CyclicBarrierDemo {
    CyclicBarrier cyclicBarrier = new CyclicBarrier(2,()->{
        log.info("all ready start run");
    });
    private static final int N = 20;
    public void demo(){
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < N; i++) {
            final int m = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            executorService.execute(() -> {
                doSomething(m);
            });
        }
        executorService.shutdown();
    }
    public void doSomething(int i){
        try {
            log.info("{} execute ready-{}" ,Thread.currentThread().getName(),i);
            cyclicBarrier.await();
            Thread.sleep(500);
            log.info("{} execute done {}",Thread.currentThread().getName(),i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new CyclicBarrierDemo().demo();
    }

}
