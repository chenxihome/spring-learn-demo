package com.chenxi.algorithm.demo.sort;

/**
 *
 *
 *插入排序：
 *
 *
 *
 * ①基本思想：在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序。
 *
 * ②算法描述：
 *
 * 从第一个元素开始，该元素可以认为已经被排序；
 *
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 *
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 *
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 *
 * 将新元素插入到该位置后；
 *
 * 重复步骤2~5。
 *
 * 稳定排序
 * 插入排序的平均时间复杂度是O（n^2）
 */
public class InsertionSort {

    //int[] arr = {1, 4, 5, 67, 2, 7, 8, 6, 9, 44};
    public static void doSort(int []arr) {
        int len=arr.length;
        int temp;
        int i,j;
        //待排序列
        for( i=1;i<len;i++) {
                temp = arr[i];
                //已排好序列
                for (j = i - 1; j >=0 &&arr[j] > temp; j--) {
                    arr[j + 1] = arr[j];
                }
                arr[j + 1] = temp;
        }
    }

    /**
     * L>0
     * @param arr
     * @param L
     * @param len
     */
    public static void doSort(int []arr,int L,int len) {
        int temp;
        int i,j;
        //待排序列
        for( i=L;i<len;i++) {
            temp=arr[i];
            //已排好序列
            for( j=i-1;j>=0&&arr[j]>temp;j--) {
                arr[j + 1] = arr[j];
            }
            arr[j+1]=temp;
        }

    }
}
