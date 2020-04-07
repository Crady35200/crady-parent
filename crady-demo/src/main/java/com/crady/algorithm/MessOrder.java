package com.crady.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * @author :Crady
 * date :2020/04/07 20:59
 * desc : 给定一个有序数组，在O(n)时间度内尽量打乱顺序
 **/
public class MessOrder {

    public static void main(String[] args) {
        Integer [] a = init(100);
        System.out.println("原始数组：");
        Arrays.stream(a).map(i -> i + ",").forEach(System.out::print);
        System.out.println();
        mess(a);
        System.out.println("乱序后数组：");
        Arrays.asList(a).stream().map(i -> i + ",").forEach(System.out::print);
//        Arrays.stream(a).forEach(System.out::print);
        System.out.println();
    }

    public static Integer [] init(int n){
        Integer a [] = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        return a;
    }

    public static void mess(Integer a[]){
        int tmp,j;
        Random r = new Random();
        for (int i = 0; i < a.length; i++) {
            j = r.nextInt(a.length - 1);
            tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
}
