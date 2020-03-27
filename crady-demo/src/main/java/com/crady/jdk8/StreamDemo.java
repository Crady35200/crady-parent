package com.crady.jdk8;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

/**
 * @author :Crady
 * date :2020/03/26 14:45
 * desc :
 **/
public class StreamDemo {

    public static void main(String[] args) {
        arrayTest();
    }

    public static void arrayTest(){
        List<String> list = Arrays.asList("one","Crady","ming");

        System.out.println("**********list.forEach***************");
        list.forEach(System.out::println);

        System.out.println("**********list.stream.forEach***************");
        list.stream().forEach(System.out::println);
        List<Integer> nums = Arrays.asList(3,5,8,2,8,3);

        System.out.println("**********数组排序(升序)***************");
        nums.stream().sorted().forEach(System.out::println);

        System.out.println("**********数组排序(降序)***************");
        nums.stream().sorted(
                (i,j) -> j.compareTo(i)
        ).forEach(System.out::println);

        System.out.println("**********Stream过滤偶数***************");
        nums.stream().filter(i -> i%2==0).forEach(System.out::println);

        System.out.println("**********Stream去重***************");
        nums.stream().distinct().forEach(System.out::println);

        System.out.println("**********Stream统计***************");
        IntSummaryStatistics statistics = nums.stream().mapToInt(i -> i).summaryStatistics();
        System.out.println(statistics);

        System.out.println("**********Stream类型转换***************");
        nums.stream().map(i -> i + "abc").forEach(System.out::println);

        System.out.println("**********Stream分页***************");
        nums.stream().limit(3).forEach(System.out::println);
    }

}
