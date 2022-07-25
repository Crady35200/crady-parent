package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/7/23 01:53
 * desc: 给你一个整数数组 nums 。nums 中，子数组的 范围 是子数组中最大元素和最小元素的差值。
 * 返回 nums 中 所有 子数组范围的 和 。
 * 子数组是数组中一个连续 非空 的元素序列。
 *
 * 示例:
 * 输入：nums = [1,2,3]
 * 输出：4
 * 解释：nums 的 6 个子数组如下所示：
 * [1]，范围 = 最大 - 最小 = 1 - 1 = 0
 * [2]，范围 = 2 - 2 = 0
 * [3]，范围 = 3 - 3 = 0
 * [1,2]，范围 = 2 - 1 = 1
 * [2,3]，范围 = 3 - 2 = 1
 * [1,2,3]，范围 = 3 - 1 = 2
 * 所有范围的和是 0 + 0 + 0 + 1 + 1 + 2 = 4
 **/
public class SubStringRange {

    public static void main(String[] args) {
        int [] array = {4,-2,-3,4,1};
        System.out.println(new SubStringRange().getSubStringRange(array));
    }


    private long getSubStringRange(int [] array) {
        if (array == null || array.length < 1) {
            return -1;
        }
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < array.length; j++) {
                min = Math.min(min, array[j]);
                max = Math.max(max, array[j]);
                sum += max - min;
            }
        }

        return sum;
    }
}
