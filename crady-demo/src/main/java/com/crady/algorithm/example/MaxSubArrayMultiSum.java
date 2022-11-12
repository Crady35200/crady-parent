package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/11/12 12:43
 * desc: 获取连续子数组乘积最大值
 * 比如：数组{1,2,5,-2,6,8,-6,5,9}
 * 连续子数组乘积最大值是：48(6,8)
 **/
public class MaxSubArrayMultiSum {

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,5,-2,6,8,-6,5,9};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        if(nums == null || nums.length < 1){
            return 0;
        }
        int max = nums[0];
        int pre = nums[0];
        for(int i=1;i<nums.length;i++) {
            pre = Math.max(pre*nums[i], nums[i]);
            max = Math.max(max,pre);
        }
        return max;
    }
}
