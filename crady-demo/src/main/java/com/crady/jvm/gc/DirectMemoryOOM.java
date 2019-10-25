package com.crady.jvm.gc;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author :Crady
 * date :2019/7/19 16:30
 * desc : 模拟直接内存溢出
 * VM Args : -XX:MaxDirectMemorySize=128m
 **/
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while(true){
            unsafe.allocateMemory(_1MB);
        }
    }

}
