package com.chenxi.algorithm.demo.sort;

/**
 * 交换排序---冒泡排序，时间复杂度 O(n2),空间复杂度O(1)
 * 基本思想：两个数比较大小，较大的数下沉，较小的数冒起来。
 * 算法描述：
 *
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 *
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 *
 * 针对所有的元素重复以上的步骤，除了最后一个；
 *
 * 重复步骤1~3，直到排序完成。
 * 稳定排序
 */
public class BubbleSort {
    public static void doSort(int arr[]) {
      int temp;
      int length=arr.length;
      for(int i=0;i<length;i++) {
          for(int j=0;j<length-i-1;j++) {
              if(arr[j]>arr[j+1]) {
                  temp=arr[j];
                  arr[j]=arr[j+1];
                  arr[j+1]=temp;
              }
          }
      }
    }
}
