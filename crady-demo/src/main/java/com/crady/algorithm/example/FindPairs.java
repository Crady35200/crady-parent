package com.crady.algorithm.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Crady
 * date: 2022/8/3 00:49
 * desc: 给你一个整数数组nums 和一个整数k，请你在数组中找出 不同的k-diff 数对，并返回不同的 k-diff 数对 的数目。
 *
 * k-diff数对定义为一个整数对 (nums[i], nums[j]) ，并满足下述全部条件：
 *
 * 0 <= i, j < nums.length
 * i != j
 * nums[i] - nums[j] == k
 * 注意，|val| 表示 val 的绝对值。
 *
 * 示例 1：
 *
 * 输入：nums = [3, 1, 4, 1, 5], k = 2
 * 输出：2
 * 解释：数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个 1 ，但我们只应返回不同的数对的数量。
 * 示例 2：
 *
 * 输入：nums = [1, 2, 3, 4, 5], k = 1
 * 输出：4
 * 解释：数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5) 。
 * 示例 3：
 *
 * 输入：nums = [1, 3, 1, 5, 4], k = 0
 * 输出：1
 * 解释：数组中只有一个 0-diff 数对，(1, 1) 。
 **/
public class FindPairs {

    public static void main(String[] args) {

        int [] array = {3, 1, 4, 1, 5};
        FindPairs findPairs = new FindPairs();
        System.out.println(findPairs.findPairs(array, 2));
        System.out.println(findPairs.findPairsBest(array, 2));

    }

    public int findPairsBest(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        Set<Integer> visitedSet = new HashSet<>();
        Set<Integer> resultSet = new HashSet<>();
        for (int n : nums) {
            if (visitedSet.contains(n - k)) {
                resultSet.add(n);
            }
            if (visitedSet.contains(n + k)) {
                resultSet.add(n+k);
            }
            visitedSet.add(n);
        }
        return resultSet.size();

    }

    /**
     * 时间复杂度O(N^2)
     * 空间复杂度O(N)
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        if (nums == null || nums.length < 1) {
            return -1;
        }
        int count = 0;
        int len = nums.length;
        Set<Integer> sets = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len ; j++) {
                if (Math.abs(nums[j] - nums[i]) == k && !sets.contains(nums[j])) {
                    sets.add(nums[j]);
                    count++;
                }
            }
        }
        return count;
    }
}
