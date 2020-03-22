package com.crady.jvm.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author :Crady
 * date :2019/7/19 14:20
 * desc :模拟堆溢出
 * VM Args: -Xms120m -Xmx120m -XX:+PrintHeapAtGC -XX:+HeapDumpOnOutOfMemoryError
 **/
public class HeapOOM {
    public static final int _SIZE_500K = 1024 * 512;
    public static void main(String[] args) throws InterruptedException {
        List<Object> list = new ArrayList<>();
        int count = 0;
        while(true){
            byte [] b = new byte[_SIZE_500K];
            list.add(b);
            TimeUnit.MILLISECONDS.sleep(50);
            if(++count >= 30){
                count = 0;
                list.clear();
            }
        }
    }
}
