package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/8/10 11:42
 * desc: 给定一个证数数组，在这个数组中只有一个数字只出现一次，其他数字都出现三次，现在需要找到这个只出现一次的整数
 * 比如：
 * 数组{1,3,6,8,6,3,1,1,3,6}
 * 则只有8出现一次
 **/
public class FindNumsAppearOnce {

    public static void main(String[] args) {
        int [] array = {1,3,6,8,6,3,1,1,3,6};
        FindNumsAppearOnce findNumsAppearOnce = new FindNumsAppearOnce();
        System.out.println(findNumsAppearOnce.findNumsAppearOnce(array));
    }


    private int findNumsAppearOnce(int [] array) {
        if (array == null || array.length < 1) {
            return -1;
        }

        int [] bits = new int[32];
        int mask = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 32; j++) {
                int re = (array[i] >> j) & mask;
                if (re > 0) {
                    bits[j] += 1;
                }
            }
        }

        int result = 0;
        for (int i = 31; i >= 0; i--) {

            result = result << 1;
            result += bits[i] % 3;

        }
        return result;

    }
}
