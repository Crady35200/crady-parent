package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/11/12 12:38
 * desc:输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释:连续子数组[4,-1,2,1] 的和最大，为6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 *
 **/
public class MaxSubArraySum {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length < 1) {
            return 0;
        }
        int max=nums[0];
        int pre=0;
        for(int n : nums) {
            pre = Math.max(pre+n,n);
            max = Math.max(max,pre);
        }
        return max;
    }
}
