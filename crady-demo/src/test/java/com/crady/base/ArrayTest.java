package com.crady.base;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author :Crady
 * date :2020/03/12 16:52
 * desc :
 *    Arrays.sort算法思想：
 *    1、如果排序元素个数>=286且有序程度(有序子数组数)小于67，且子数组中相当等元素小于33个则使用归并排序。
 *    2、不满足1条件则继续判断如果元素小于47则使用插入排序(如果其实元素是最左侧的元素则使用经典插入排序算法，否则使用双插入排序)。
 *    3、不满足条件2则使用双轴快速排序。
 **/
public class ArrayTest {

    @Test
    public void test01(){
        int [] array = new int[]{4,2,1,5,3};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
    }
}
