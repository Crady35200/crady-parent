package com.crady.jvm;

/**
 * @author :Crady
 * date :2019/7/24 14:26
 * desc :
 * JVM Args : -client -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails  -XX:SurvivorRatio=8
 **/
public class MemoryAllocationDemo {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte [] a1,a2,a3,a4;
        a1 = new byte[2*_1MB];
        System.out.println("************1************");
        a2 = new byte[2*_1MB];
        System.out.println("************2************");
        a3 = new byte[2*_1MB];
        System.out.println("************3************");
        a4 = new byte[4*_1MB];
        System.out.println("************4************");
//        System.out.println(a1);
//        System.out.println(a2);
//        System.out.println(a3);
//        System.out.println(a4);
    }
}
