package com.chenxi.algorithm.demo;

import com.chenxi.algorithm.demo.sort.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        quickSort();
        bubbleSort();
        insertionSort();
        shellSort();
        selectionSort();
        heapSort();
        mergeSort();
    }

    @Test
    void quickSort() {
        int[] arr = {10, 4, 5, 67, 2, 7, 8, 6, 9, 44};
        System.out.println("快排前---"+ Arrays.toString(arr));
        QuickSort.doSort(arr,0,9);
        System.out.println("快排后---"+Arrays.toString(arr));
    }
    @Test
    void bubbleSort() {
        int[] arr = {11, 4, 5, 67, 2, 7, 8, 6, 9, 44};
        System.out.println("冒泡前---"+ Arrays.toString(arr));
        BubbleSort.doSort(arr);
        System.out.println("冒泡后---"+Arrays.toString(arr));
    }


    @Test
    void insertionSort() {
        int[] arr = {100, 40, 5, 67, 12, 70, 8, 6, 9, 44};
        System.out.println("插入前---"+ Arrays.toString(arr));
        InsertionSort.doSort(arr);
        System.out.println("插入后---"+Arrays.toString(arr));
    }


    @Test
    void shellSort() {
        int[] arr = {100, 40, 5, 67, 12, 70, 8, 6, 9, 44};
        System.out.println("Shell排序前---"+ Arrays.toString(arr));
        ShellSort.doSort(arr);
        System.out.println("Shell排序后---"+Arrays.toString(arr));
    }

    @Test
    void selectionSort() {
        int[] arr = {100, 40, 5, 67, 12, 70, 8, 6, 9, 44};
        System.out.println("选择排序前---"+ Arrays.toString(arr));
        SelectionSort.doSort(arr);
        System.out.println("选择排序后---"+Arrays.toString(arr));
    }


    @Test
    void heapSort() {
        int[] arr = {100, 40, 5, 67, 12, 70, 8, 6, 9, 44};
        System.out.println("堆排序前---"+ Arrays.toString(arr));
        HeapSort.doSort(arr);
        System.out.println("堆排序后---"+Arrays.toString(arr));
    }

    @Test
    void mergeSort() {
        int[] arr = {100, 40, 5, 67, 12, 70, 8, 6, 9, 44};
        System.out.println("归并排序前---"+ Arrays.toString(arr));
        MergeSort.doSort(arr);
        System.out.println("归并排序后---"+Arrays.toString(arr));
    }
}
