package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/7/21 17:28
 * desc:有一个整型数组，数组元素不重复，数组元素先升序后降序，
 *
 * 例如：1,3,5,7,9,8,6,4,2，请写一个函数找出数组最大的元素。
 **/
public class FindMaxArrayInteger {

    public static void main(String[] args) {

        int [] array = {1,3,5,7,9,8,6,4,2};

        System.out.println("getArrayMaxInt, result = " + new FindMaxArrayInteger().getArrayMaxInt(array));

        System.out.println("result = " + new FindMaxArrayInteger().getArrayMaxInteger(array));

    }

    /**
     * 二分查找法
     * 时间复杂度：O(lgn)
     * 空间复杂度：O(1)
     * @param array
     * @return
     */
    public int getArrayMaxInt(int [] array) {
        if (array == null || array.length < 1) {
            return  -1;
        }
        int right = array.length - 1;
        int left = 0;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (array[mid] < array[mid + 1]) {
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return array[left];

    }

        public int getArrayMaxInteger(int [] array) {

        if (array == null) {
            return -1;
        }
        int i = array.length / 2;
        int max = array[i];

        if (i + 1 < array.length && max < array[i+1]) {
            while (i < array.length && max < array[i+1]) {
                max = array[++i];
            }
        }else {
            while(i > 0 && max < array[i - 1]) {
                max = array[--i];
            }
        }

        return max;

    }
}
