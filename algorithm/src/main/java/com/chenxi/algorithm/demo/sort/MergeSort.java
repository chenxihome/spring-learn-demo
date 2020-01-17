package com.chenxi.algorithm.demo.sort;

/**
 * ①基本思想：
 *
 * 归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并。
 *
 * ②算法描述：
 *
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 *
 * 对这两个子序列分别采用归并排序；
 *
 * 将两个排序好的子序列合并成一个最终的排序序列。
 */
public class MergeSort {


    public static void doSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    // 归并
    private static void mergeSort(int array[], int first, int last, int temp[]) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(array, first, mid, temp); // 递归归并左边元素
            mergeSort(array, mid + 1, last, temp); // 递归归并右边元素
            mergeArray(array, first, mid, last, temp); // 再将二个有序数列合并
        }
    }



    /**
     * 合并两个有序数列
     * array[first]~array[mid]为第一组
     * array[mid+1]~array[last]为第二组
     * temp[]为存放两组比较结果的临时数组
     */
    private static void mergeArray(int array[], int first, int mid, int last, int temp[]) {
        int i = first, j = mid + 1; // i为第一组的起点, j为第二组的起点
        int m = mid, n = last; // m为第一组的终点, n为第二组的终点
        int k = 0; // k用于指向temp数组当前放到哪个位置
        while (i <= m && j <= n) { // 将两个有序序列循环比较, 填入数组temp
            if (array[i] <= array[j])
                temp[k++] = array[i++];
            else
                temp[k++] = array[j++];
        }
        while (i <= m) { // 如果比较完毕, 第一组还有数剩下, 则全部填入temp
            temp[k++] = array[i++];
        }
        while (j <= n) {// 如果比较完毕, 第二组还有数剩下, 则全部填入temp
            temp[k++] = array[j++];
        }
        for (i = 0; i < k; i++) {// 将排好序的数填回到array数组的对应位置
            array[first + i] = temp[i];
        }
    }
}

