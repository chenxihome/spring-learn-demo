package com.chenxi.algorithm.demo.sort;

/**
 * 选择排序
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
 * 稳定排序 时间复杂度O(n^2)
 */
public class SelectionSort {
    public static void doSort(int []arr) {
        int min;
        int len=arr.length;
        for(int i=0;i<len;i++) {
            min=i;
            for(int j=i+1;j<len;j++) {
                if(arr[min]>arr[j]) {
                   min=j;
                }
            }
            if(i!=min) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
}
