package com.crady.thread.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * author:Crady
 * date:2019/04/18 22:30
 * desc: 把一个大的耗时的任务拆分成多个子任务并且使用多线程执行，然后等待
 * 子任务执行完成后合并子任务结果
 **/
public class ForkJoinDemo extends RecursiveTask<Integer> {

    private static final Logger logger = LoggerFactory.getLogger(ForkJoinDemo.class);

    private static final int threshold = 50;
    private int start;
    private int end;

    public ForkJoinDemo(int start,int end){
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        boolean flag = (end - start) > threshold ? false : true;
        if(flag){
            return sum(start,end);
        }else{
            int middle = (start + end) / 2;
            ForkJoinDemo leftTask = new ForkJoinDemo(start,middle);
            ForkJoinDemo rightTask = new ForkJoinDemo(middle + 1,end);

            //执行子任务
            leftTask.fork();
            rightTask.fork();
            //等待子任务结束
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            //合并子任务
            return leftResult + rightResult;
        }
    }

    /**
     * 模拟耗时工作
     * @param m
     * @param n
     * @return
     */
    public int sum(int m,int n){
        int sum = 0;
        for (int i = m; i <= n; i++) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sum += i;
        }
        return sum;
    }
    public static void main(String []args)throws Exception{
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Future<Integer> result = forkJoinPool.submit(new ForkJoinDemo(1,1000));
        long start = System.currentTimeMillis();
        int r1 = result.get();
        logger.info("task is done,result : {},耗时:{}",r1,(System.currentTimeMillis() - start));
        long middle = System.currentTimeMillis();
        int r2 = new ForkJoinDemo(0,1).sum(1,1000);
        logger.info("===============1-1000:{},耗时：{}",r2,System.currentTimeMillis() - middle);
    }
}
