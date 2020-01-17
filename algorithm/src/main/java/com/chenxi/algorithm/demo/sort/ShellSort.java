package com.chenxi.algorithm.demo.sort;

/**
 * 插入排序---升级版 希尔排序
 * 不稳定 时间复杂度O(n^2)
 * 算法关键  是gap 选取
 */
public class ShellSort {


    //int[] arr = {1, 4, 5, 67, 2, 7, 8, 6, 9, 44};
    public static void doSort(int []arr) {
        int len = arr.length;
        for (int gap = len / 2; gap >= 1; gap = gap / 2) {
            InsertionSort.doSort(arr, gap, len);
        }
    }



}
