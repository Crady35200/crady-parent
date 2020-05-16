package com.crady.thread.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author :Crady
 * date :2020/05/16 11:23
 * desc : 线程池参数动态调整(主要调整核心和最大线程数)
 * 如果要调整阻塞队列大小，因为阻塞队列大小Capacity是final的，所以需要自定义阻塞队列
 **/
public class CustomThreadPoolExecutor {

    private static final int N = 15;


    public static void main(String[] args) throws InterruptedException {
        CountDownLatch cd = new CountDownLatch(N);
        CustomThreadPoolExecutor executor = new CustomThreadPoolExecutor();
        ThreadPoolExecutor threadPoolExecutor = executor.buildThreadPoolExecutor();
        for (int i = 0; i < N; i++) {
            threadPoolExecutor.submit(() -> {
               executor.threadPoolExecutorStatus(threadPoolExecutor,"创建线程:");
                try {
                    TimeUnit.SECONDS.sleep(10);
                    cd.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.threadPoolExecutorStatus(threadPoolExecutor,"改变前：");
        threadPoolExecutor.setCorePoolSize(10);
        //如果不设置最大线程数，当修改核心线程数大于最大线程数时，活跃线程数不会大于最大线程数
        threadPoolExecutor.setMaximumPoolSize(10);
        executor.threadPoolExecutorStatus(threadPoolExecutor,"改变后:");
        cd.await();
        threadPoolExecutor.shutdown();

    }

    public ThreadPoolExecutor buildThreadPoolExecutor(){
        return new ThreadPoolExecutor(2,
                5,60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(10),
                new CustomThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }

    public void threadPoolExecutorStatus(ThreadPoolExecutor threadPoolExecutor,String title){
        LinkedBlockingQueue queue = (LinkedBlockingQueue) threadPoolExecutor.getQueue();
        String str = String.format(title + "[%s]核心线程数:%d,活跃线程数:%d,最大线程数:%d," +
                "线程池活跃度:%s,任务完成数:%d,当前排队线程数:%d," +
                "队列剩余大小:%d,队列大小:%d,队列使用度:%s",
                new SimpleDateFormat("HH:mm:ss SSS").format(new Date()),
                threadPoolExecutor.getCorePoolSize(),
                threadPoolExecutor.getActiveCount(),
                threadPoolExecutor.getMaximumPoolSize(),
                cal(threadPoolExecutor.getActiveCount(),threadPoolExecutor.getMaximumPoolSize()),
                threadPoolExecutor.getCompletedTaskCount(),
                queue.size(),queue.remainingCapacity(),
                queue.size() + queue.remainingCapacity(),
                cal(queue.size(),queue.size() + queue.remainingCapacity()));
        System.out.println(str);

    }

    public static String cal(int a,int b){
        return String.format("%1.2f%%",Double.valueOf(a)/Double.valueOf(b));
    }

    static class CustomThreadFactory implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        CustomThreadFactory() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            namePrefix = "pool-" +
                    poolNumber.getAndIncrement() +
                    "-thread-crady-";
        }

        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon())
                t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY)
                t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
