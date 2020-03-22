package com.crady.jvm.gc;

/**
 * @author :Crady
 * date :2020/03/21 21:08
 * desc :动态年龄
 * VM Args: -Xms20m -Xmx20m -Xmn10m -XX:+PrintHeapAtGC -XX:+PrintGCDetails
 **/
public class MaxTenuringThresholdDemo {

    public static final int _SIZE_1M = 1024 * 1024;

    public static void main(String[] args) {
        byte [] b1,b2,b3,b4;
        b1 = new byte[_SIZE_1M / 4];
        b2 = new byte[_SIZE_1M / 4];
        b3 = new byte[_SIZE_1M * 4];
        b4 = new byte[_SIZE_1M * 4];
        b4 = null;
        b4 = new byte[_SIZE_1M * 4];
    }

}
