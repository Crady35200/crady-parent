package com.crady.jvm.gc;

/**
 * @author :Crady
 * date :2020/05/14 09:10
 * desc :
 **/
public class FullGC {

    private static final int _1M = 1024 * 1024;
    private static final int _1K = 1024;

    public static void main(String[] args) {
        FullGC fg = new FullGC();
        fg.promoteFailFullGc();
    }

    /**
     * 新生代GC，老年代担保失败
     * -Xms20m -Xmx20m -Xmn10m -XX:PretenureSizeThreshold=3m -XX:+PrintGCDetails -XX:+UseConcMarkSweepGC -XX:+PrintGCDateStamps -XX:+PrintGCTimeStamps
     */
    public void promoteFailFullGc(){
        //大于3m的直接在老年代分配
        byte [] b1 = new byte[6*_1M];
        b1 = null;
        //在eden区分配
        byte [] b2 = new byte[2*_1M];
        //在eden区分配
        byte [] b3 = new byte[2*_1M];
        //在eden区分配
        byte [] b4 = new byte[2*_1M];
        //在eden区分配
//        byte [] b5 = new byte[512*_1K];
        //年老代不足promote fail进行fullGC
        byte [] b6 = new byte[2*_1M];

    }
}
