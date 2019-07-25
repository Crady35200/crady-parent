package com.crady.algorithm;

/**
 * author:Crady
 * date:2019/07/25 20:23
 * desc:一个长度为n的数组，其中数组中每个元素的值都小于n的非负数，如何用O(n)的算法判断数组中是否存在重复元素
 **/
public class Algorithm1 {
    public static void main(String[] args) {
        Integer [] array = new Integer[]{1,2,3,5,6,5,3,0,0};
        System.out.println("******************方法一**************************");
        isArrayContainsRepeatElement(array);
        System.out.println("******************方法二**************************");
        isArrayContainsRepeatElement2(array);
        System.out.println("******************方法三**************************");
        isArrayContainsRepeatElement3(array);
    }

    /**
     * 时间O(n)，空间O(N) 能处理0~n的数
     * @param array
     * @return
     */
    public static boolean isArrayContainsRepeatElement(Integer [] array){
        if(array == null || array.length < 1){
            throw new RuntimeException("array must not be null");
        }
        Integer [] result = new Integer[array.length + 1];
        for (int i = 0; i < array.length; i++) {
            if(result[array[i]] == array[i]){
                System.out.println("重复元素:" + array[i]);
            }else{
                result[array[i]] = array[i];
            }
        }
        return false;
    }

    /**
     * 时间O(nk)，空间O(1)  能处理0~n-1的数
     * @param array
     * @return
     */
    public static boolean isArrayContainsRepeatElement2(Integer [] array){
        boolean flag = false;
        int tmp;
        for (int i = 0; i < array.length; i++) {
            while(i != array[i]){
                if(array[i] != array[array[i]]){
                    tmp = array[array[i]];
                    array[array[i]] = array[i];
                    array[i] = tmp;
                }else {
                    flag = true;
                    System.out.println("重复元素:" + array[i]);
                    break;
                }
            }
        }
/*        for (int i = 0; i < array.length; i++) {
            System.out.println("array[" + i+ "]=" + array[i]);
        }*/
        return flag;
    }

    /**
     * 时间O(n)，空间O(1)  能处理0~n-1的数
     * @param array
     * @return
     */
    public static boolean isArrayContainsRepeatElement3(Integer [] array){
        boolean flag = false;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            int index = array[i] > length ? array[i] - length : array[i];
            if(array[index] >= length){
                flag = true;
                System.out.println("重复元素:" + (array[index] - length));
            }else{
                array[index] += length;
            }
        }
        return flag;
    }
}
