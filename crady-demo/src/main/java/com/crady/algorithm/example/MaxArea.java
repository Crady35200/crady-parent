package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/7/22 02:32
 * desc: 11. 盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * 链接：https://leetcode.cn/problems/container-with-most-water
 **/
public class MaxArea {

    public static void main(String[] args) {
        int [] array = {1,8,6,2,5,4,8,3,7};
        System.out.println(new MaxArea().getMaxAreaPro(array));
        System.out.println(new MaxArea().getMaxArea(array));
    }

    /**
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * @param array
     * @return
     */
    public int getMaxAreaPro (int [] array) {
        if (array == null || array.length < 1) {
            return -1;
        }
        int max = 0;
        int i = 0;
        int j = array.length - 1;
        while (i < j) {
            int area = Math.max(array[i], array[j]) * (j - i);
            max = Math.max(max, area);
            if (array[i] > array[j]) {
                j--;
            } else {
                i++;
            }
        }
        return max;
    }


    /**
     *  时间复杂度：O(n*n)
     *  空间复杂度：O(1)
     * @param array
     * @return
     */
    public int getMaxArea( int [] array) {
        if (array == null || array.length < 1) {
            return  -1;
        }
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int min = array[i] > array[j] ? array[j] : array[i];
                int area = (j - i) * min;
                max = area > max ? area : max;
            }
        }
        return max;
    }
}
