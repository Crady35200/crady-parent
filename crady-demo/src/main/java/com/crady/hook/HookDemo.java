package com.crady.hook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Crady
 * date: 2022/9/8 21:31
 * desc: 系统退出的时候如果有多个资源需要关闭，且关闭的资源需要安装指定的顺序关闭即可。
 **/
public class HookDemo {

    public static void main(String[] args) {

        System.out.println("----start----");

        Work w1 = new Work(1) {
            @Override
            public void doWork(Object o) {
                System.out.println("one");
            }
        };
        Work w2 = new Work(8) {
            @Override
            public void doWork(Object o) {
                System.out.println("eight");
            }
        };

        Work w3 = new Work(3) {
            @Override
            public void doWork(Object o) {
                System.out.println("three");
            }
        };

        XThread.addWork(w1);
        XThread.addWork(w2);
        XThread.addWork(w3);

        Runtime.getRuntime().addShutdownHook(XThread.getThread());
        System.out.println("----end----");
    }

    static class XThread {
        private static List<Work> workList = new ArrayList<>();
        public static List<Work> addWork(Work w) {
            workList.add(w);
            return workList;
        }
        public static Thread getThread() {
            workList = workList.stream().sorted().collect(Collectors.toList());
            return new Thread(() -> {
                for(Work w : workList) {
                    w.doWork(null);
                }
            });

        }
    }

    abstract static class Work<T> implements Comparable<Work>{
        private int order;

        public Work(int order) {
            this.order = order;
        }
        public abstract void doWork(T t);

        @Override
        public int compareTo(Work o) {
            return this.order - o.order;
        }
    }



}
