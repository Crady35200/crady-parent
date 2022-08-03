package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/8/3 02:17
 * desc:
 **/
public class PivotArray {

    public static void main(String[] args) {
        int [] array = {9,12,5,10,14,3,10};
        PivotArray pivotArray = new PivotArray();
        pivotArray.printArray(pivotArray.pivotArray(array, 10));
    }

    public int[] pivotArray(int[] nums, int pivot) {

        if (nums == null || nums.length < 1) {
            return null;
        }
        int n = nums.length, k = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                ans[k++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == pivot) {
                ans[k++] = nums[i];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > pivot) {
                ans[k++] = nums[i];
            }
        }
        return ans;

    }

    private void printArray(int [] array) {
        if (array == null || array.length < 1) {
            return;
        }
        for(int n : array) {
            System.out.print(n + ",");
        }
        System.out.println();
    }

}
