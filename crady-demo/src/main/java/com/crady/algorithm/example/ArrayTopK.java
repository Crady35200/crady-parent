package com.crady.algorithm.example;

import java.util.Arrays;

/**
 * @author: Crady
 * date: 2022/11/15 22:27
 * desc: 给定一个无序数组，在O(N)的时间和空间获取最大的第K个数
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *
 * 链接：https://leetcode.cn/problems/kth-largest-element-in-an-array
 **/
public class ArrayTopK {

    public static void main(String[] args) {
        int [] nums = new int[]{3,2,1,5,6,4};
        System.out.println(findKthLargest(nums,2));
        int [] nums2 = new int[]{3,2,3,1,2,4,5,5,6};
        System.out.println(findKthLargest(nums2,4));
    }

    public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k) {
            return -1;
        }
        return exec(nums,0,nums.length-1, nums.length - k);

    }
    public static int exec(int [] nums, int start, int end, int k){
        int n = quickSelect(nums,start,end);
        if(n == k){
            Arrays.stream(nums).forEach(System.out::print);
            System.out.println();
            return nums[n];
        }else if(n > k ){
            return exec(nums,start,n-1,k);
        }else{
            return exec(nums,n+1,end,k);
        }

    }

    public static int quickSelect(int [] nums, int start, int end){
        int mid = start + (end-start)/2;
        swap(nums,start,mid);
        int k = nums[start];
        int s = start, e = end;
        while(s < e){
            while(s < e && nums[e] >= k){
                e--;
            }
            while(s < e && nums[s] <= k){
                s++;
            }
            if(s < e){
                swap(nums,s,e);
            }
        }
        swap(nums,s,start);
        return s;
    }

    public static void swap(int [] nums, int a, int b){
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}
