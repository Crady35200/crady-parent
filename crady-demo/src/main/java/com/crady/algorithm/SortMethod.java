package com.crady.algorithm;

import java.util.Arrays;
import java.util.Random;

/**
 * author:Crady
 * date:2019/09/05 21:54
 * desc: 排序算法
 **/
public class SortMethod {

    public static void main(String[] args) {
        int N = 20;
        int [] array = new int[N];
        Random r = new Random();

        for (int i = 0; i < N; i++) {
            array[i] = r.nextInt(100);
        }
        System.out.println("排序前数组：");
        print(array);
        System.out.println("排序后数组：");
//        insertSort(array);


//        int [] array = new int[]{2,8,7,18,9,3,6,12,11,15};
//        bubbleSort(array);
//        bubbleSort2(array);
//        selectSort(array);
//        quickSort(array,0,array.length - 1);
//        heapSort1(array);
          print(mergeSort(array));
//        print(array);
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
        for (int i = 1; i < array.length; i++) {
            boolean flag = false;
            for (int j = 0; j < array.length - i; j++) {
                n++;
                if(array[j + 1] < array[j]){
                    tmp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = tmp;
                    flag = true;
                }
            }
            if(!flag){//最好的情况下，时间复杂度为n，因为有序直接推出循环
                break;
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
            boolean flag = false;
            for(int j = 0; j < i; j++){    //内层循环遍历游标及之后(或之前)的元素
                n++;
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag = true;
                }
            }
            if(!flag){//最好的情况下，时间复杂度为n，因为有序直接推出循环
                break;
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

    /**
     * 堆排序：使用大顶堆做升序排序(递归实现)
     * 排序规则：
     * 1、先n个元素的无序序列，构建成大顶堆。
     * 2、将根节点与最后一个元素交换位置，（将最大元素"沉"到数组末端）。
     * 3、交换过后可能不再满足大顶堆的条件，所以需要将剩下的n-1个元素重新构建成大顶堆。
     * 4、重复第2步、第3步直到整个数组排序完成
     * @param array
     */
    public static void heapSort(int [] array){
        if(array == null || array.length < 1){
            return;
        }
        int tmp;
        for (int i = array.length; i > 1; i--) {
            buildBigHeap(array,i);
            tmp = array[0];
            array[0] = array[i - 1];
            array[i - 1] = tmp;
        }
        print(array);

    }

    public static void buildBigHeap(int [] array,int len){
        if(array == null || array.length < 1 || len > array.length){
            return;
        }
        int mi = len/2 - 1;
        int tmp;
        while(mi >= 0){
            int c = mi * 2 + 1;
            if(c < len && array [mi] < array[c]){
                tmp = array[mi];
                array[mi] = array[c];
                array[c] = tmp;
            }
            if(c + 1 < len && array [mi] < array[c + 1]){
                tmp = array[mi];
                array[mi] = array[c + 1];
                array[c + 1] = tmp;
            }
            if((c*2+1 < len && array[c*2+1] > array[c]) || (c*2+2 < len && array[c*2+2] > array[c])){
                buildBigHeap(array,len);
            }
            mi--;
        }
    }

    /**
     * 堆排序：使用大顶堆做升序排序(非递归实现)
     * 1、先n个元素的无序序列，构建成大顶堆。
     * 2、将根节点与最后一个元素交换位置，（将最大元素"沉"到数组末端）。
     * 3、交换过后可能不再满足大顶堆的条件，所以需要将剩下的n-1个元素重新构建成大顶堆。
     * 4、重复第2步、第3步直到整个数组排序完成
     * @param array
     */
    public static void heapSort1(int [] array){
        if(array == null || array.length < 1){
            return;
        }
        int len = array.length;
        //每次获取一个最大值，需要获取N-1次，最后一次可以不需要
        while(len > 1){
            //获取该堆的最后一个非叶子节点
            int mi = len/2 - 1;
            int tmp;
            //从最后一个非叶子节点开始，循环到堆顶，每个子树都要满足大顶堆特点
            while(mi >=0){
                int c = 2*mi + 1;
                //如果该节点的叶子节点比该节点值大则需要交换数据
                while((c < len && array[c] > array[mi]) || (c+1 < len && array[c+1] > array[mi])){
                    if(c < len && array [mi] < array[c]){
                        tmp = array[mi];
                        array[mi] = array[c];
                        array[c] = tmp;
                    }
                    if(c + 1 < len && array [mi] < array[c + 1]){
                        tmp = array[mi];
                        array[mi] = array[c + 1];
                        array[c + 1] = tmp;
                    }
                    c = 2*c + 1;
                }
                mi--;
            }
            tmp = array[0];
            array[0] = array[len -1];
            array[len - 1] = tmp;
            len --;
        }
        print(array);

    }

    /**
     * 1、把第一个元素当做最小的数字(相当于只有一个元素的有序数组)。
     * 2、从第二个元素开始遍历，取每个元素与第一步中的每个元素对比
     * 如果小于1中的某个元素，这交换位置。
     * 3、重复1和2步骤。
     * @param array
     */
    public static void insertSort(int [] array){
        if(null == array || array.length < 1){
            return;
        }
        int tmp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if(array[i] < array[j]){
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        print(array);
    }

    /**
     * 归并排序-递归实现,容易出现栈溢出
     * @param array
     * @return
     */
    public static int[] mergeSort(int [] array){
        if(null == array || array.length < 1){
            return null;
        }
        if(array.length < 2){
            return array;
        }
        //递归调用，直到数组拆分为单个元素的数组，然后依次合并各个数组
        int mid = array.length >> 1;
        int[] low = Arrays.copyOfRange(array,0,mid);
        int[] high = Arrays.copyOfRange(array,mid,array.length);
        return merge(mergeSort(low),mergeSort(high));

    }

    /**
     * 合并两个有序的数组
     * @param low
     * @param high
     * @return
     */
    public static int [] merge(int [] low,int [] high){
        if(low == null || low.length < 1){
            return high;
        }
        if(high == null || high.length < 1){
            return low;
        }
        int [] temp = new int[low.length + high.length];
        int i=0,j=0,k=0;
        while(i < low.length && j < high.length){
            if(low[i] < high[j]){
                temp[k++] = low[i++];
            }else{
                temp[k++] = high[j++];
            }
        }
        while(i < low.length){
            temp[k++] = low[i++];
        }
        while(j < high.length){
            temp[k++] = high[j++];
        }
        return temp;
    }



    public static void print(int [] array){
        for (int n : array) {
            System.out.print(n + ",");
        }
        System.out.println();
    }

}
