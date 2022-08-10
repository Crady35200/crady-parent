package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/8/10 11:42
 * desc: 给定一个证数数组，在这个数组中只有一个数字只出现一次，其他数字都出现两次，现在需要找到这个只出现一次的整数
 * 比如：
 * 数组{1,3,2,6,3,2,1}
 * 则只有6出现一次
 **/
public class FindNumsAppearOnce2 {

    public static void main(String[] args) {
        int [] array = {1,3,2,6,3,2,1};
        FindNumsAppearOnce2 findNumsAppearOnce = new FindNumsAppearOnce2();
        System.out.println(findNumsAppearOnce.findNumsAppearOnce(array));
    }


    private int findNumsAppearOnce(int [] array) {
        if (array == null || array.length < 1) {
            return -1;
        }

        int n = 0;
        for (int i : array) {
            n ^= i;
        }
        return n;
    }
}
