package com.crady.jvm.gc;

/**
 * @author :Crady
 * date :2020/03/21 21:34
 * desc : 测试大对象直接进入老年代，大于4M的对象直接进入老年代
 * VM Args: -Xms20m -Xmx20m -Xmn10m -XX:PretenureSizeThreshold=3145728  -XX:+PrintHeapAtGC -XX:+PrintGCDetails
 **/
public class PretenureSizeThresholdDemo {

    public static final int _SIZE_1M = 1024 * 1024;

    public static void main(String[] args) {
        byte [] b = new byte[4 * _SIZE_1M];
    }

}
