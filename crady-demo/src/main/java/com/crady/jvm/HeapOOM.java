package com.crady.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :Crady
 * date :2019/7/19 14:20
 * desc :模拟堆溢出
 * VM Args: -Xms100m -Xmx100m -XX:+HeapDumpOnOutOfMemoryError
 **/
public class HeapOOM {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        while(true){
            list.add(new Object());
        }
    }
}
