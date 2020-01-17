package com.chenxi.algorithm.demo.sort;
/**
 * 交换排序---快速排序，时间复杂度 O(nlogn),空间复杂度O(nlogn) 不稳定
 */
public class QuickSort {
    //int[] arr = {1, 4, 5, 67, 2, 7, 8, 6, 9, 44};
    public static void doSort(int []arr,int L,int R) {
       int i=L;
       int j=R;
       int prov=(L+R)/2;
       while (i<=j) {
           while (arr[prov] > arr[i]) {
               i++;
           }
           while (arr[prov] < arr[j]) {
               j--;
           }
           if (i <= j) {
               int temp = arr[i];
               arr[i] = arr[j];
               arr[j] = temp;
               i++;
               j--;
           }
       }
           if(L<j) {
              doSort(arr,L,j);
           }
           if(i<R){
               doSort(arr,i,R);
           }
    }
}
