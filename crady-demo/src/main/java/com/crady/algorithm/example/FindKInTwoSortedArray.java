package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/11/1 18:35
 * desc: 在两个有序整数数组中获取第K小的数字
 * 如：     int[] a = {1, 3, 5, 9};
 *         int[] b = {2, 4, 6, 10};
 *         K=5 则输出5
 *         K=7 则输出9
 *
 **/
public class FindKInTwoSortedArray {


    public static void main(String[] args) {
        int[] a = {1, 3, 5, 9};
        int[] b = {2, 4, 6, 10};
        System.out.println(findK(a,b,5));
        System.out.println(findK2(a,b,5));
    }

    /**
     * 时间复杂度O(logK),空间复杂度O(1)
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static int findK2(int [] a, int b[], int k) {

        int aLen = a.length;
        int bLen = b.length;
        if(aLen + bLen < k){
            return -1;
        }
        int as=0,am;
        int bs=0,bm;
        int result = 0;
        while(k > 0){
            if(k==1){
                if(as < aLen && bs < bLen){
                    result = a[as] < b[bs] ? a[as] : b[bs];
                }else {
                    result = as >= aLen ? b[bs] : a[as];
                }
                break;
            }
            am = aLen - as > 0 ? k/2>aLen-as ? aLen-1: as+k/2-1:aLen;
            bm = bLen - bs > 0 ? k/2>bLen-bs ? bLen-1: bs+k/2-1:bLen;
            if(am < aLen && bm < bLen){
                if(a[am] < b[bm]) {
                    as = am + 1;
                }else if (a[am] > b[bm]){
                    bs = bm + 1;
                }else {
                    result = a[am];
                    break;
                }
                k = k - k/2;
            }else {
                result = aLen > bLen ? a[am + k - 1] : b[bm+k-1];
                break;
            }

        }
        return result;
    }

    /**
     * 时间复杂度O(K),空间复杂度O(1)
     * @param a
     * @param b
     * @param k
     * @return
     */
    public static int findK(int [] a, int b[], int k) {

        int aLen = a.length;
        int bLen = b.length;
        int i=0,j=0;
        int n=0;
        int result;
        while(i < a.length && j < b.length) {
            if(a[i] < b[j]){
                result = a[i];
                i++;
            }else{
                result = b[j];
                j++;
            }
            n++;
            if(n == k) {
                return  result;
            }
        }

        if(n < k) {
            if(aLen > bLen){
                return b[j + k - n];
            }else {
                return a[i + k - n];
            }
        }

        return -1;


    }
}
