package com.crady.algorithm;

/**
 * author:Crady
 * date:2019/09/05 21:54
 * desc: 排序算法
 **/
public class SortMethod {

    public static void main(String[] args) {
        int [] array = new int[]{2,3,4,5,6,7};
//        int [] array = new int[]{2,8,7,18,9,3,6,12,11,15};
//        bubbleSort(array);
//        bubbleSort2(array);
//        selectSort(array);
        quickSort(array,0,array.length - 1);
        print(array);
    }

    /**
     *冒泡排序：1、循比较相邻的元素。如果第一个比第二个大，就交换他们两个。
     * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
     * 3、针对所有的元素重复以上的步骤，除了最后一个。
     * 4、持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
     * 时间复杂度：平均时间复杂度：O(n~2)  最好:O(n)  最坏:O(n~2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     * @param array
     * @return
     */
    public static void bubbleSort(int array[]){
        System.out.println("*****************冒泡排序**************");
        long start = System.nanoTime();
        if(array == null || array.length < 1){
            return;
        }
        int tmp;
        int n = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                n++;
                if(array[j + 1] < array[j]){
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                }
            }
        }
        System.out.println("比较次数 bubbleSort n=" + n);
        System.out.println("冒泡排序用时:" + (System.nanoTime() - start) + " nanos");
        print(array);
    }

    /**
     * 冒泡排序2
     * @param array
     */
    public static void bubbleSort2(int[] array){
        System.out.println("*****************冒泡排序2**************");
        long start = System.nanoTime();
        if(array == null || array.length < 1){
            return;
        }
        int n = 0;
        int temp;
        for (int i = array.length - 1; i > 0; i--) { //外层循环移动游标
            for(int j = 0; j < i; j++){    //内层循环遍历游标及之后(或之前)的元素
                n++;
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println("冒泡排序用时:" + (System.nanoTime() - start) + " nanos");
        System.out.println("比较次数 bs n=" + n);
        print(array);
    }

    /**
     * 选择排序: 1、从待排序序列中，找到关键字最小的元素。
     * 2、如果最小元素不是待排序序列的第一个元素，将其和第一个元素互换。
     * 3、从余下的 N - 1 个元素中，找出关键字最小的元素，重复①、②步，直到排序结束。
     * 时间复杂度：平均时间复杂度：O(n~2)  最好:O(n~2)  最坏:O(n~2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     * @param array
     */
    public static void selectSort(int [] array){
        long start = System.nanoTime();
        if(array == null || array.length < 1){
            return;
        }
        int n = 0;
        int tmp;
        int min;
        for (int i = 0; i < array.length; i++) {
            min = i;
            for (int j = i + 1; j < array.length; j++) {
                n++;
                if(array[j] < array[min]){
                    min = j;
                }
            }
            if(i != min){
                tmp = array[i];
                array[i] = array[min];
                array[min] = tmp;
            }
            
        }
        System.out.println("选择排序用时:" + (System.nanoTime() - start) + " nanos");
        System.out.println("选择排序 n=" + n);
        print(array);
    }

    /**
     * 1、默认取第一个数作为基准。
     * 2、从最右边向左搜索比基准小的记录array[h]。
     * 3、从最左边向右搜索比基准大的记录array[l]。
     * 4、如果h>l则交换两者值。
     * 5、如果l=h则想换l和基准的值。
     * 6、进行新的一轮比较。
     * 时间复杂度：平均时间复杂度：O(nlogn)  最好:O(nlogn)  最坏:O(n~2)
     * 空间复杂度：O(logn)
     * 稳定性：不稳定
     * @param array
     * @param low
     * @param high
     */
    public static void quickSort(int [] array,int low,int high){
        if(array == null || array.length < 1){
            return;
        }
        if(high < low){
            return;
        }
        int k = array[low];
        int l = low;
        int h = high;
        int tmp;
        while (l < h){

            while(l < h && array[h] >= k){
                h --;
            }
            while(l < h && array[l] <= k){
                l ++;
            }
            if(l < h){
                tmp = array[l];
                array[l] = array[h];
                array[h] = tmp;
            }
        }
        array[low] = array[l];
        array[l] = k;
        quickSort(array,low,h - 1);
        quickSort(array,h + 1,high);

    }

    public static void print(int [] array){
        for (int n : array) {
            System.out.print(n + ",");
        }
        System.out.println();
    }

}
