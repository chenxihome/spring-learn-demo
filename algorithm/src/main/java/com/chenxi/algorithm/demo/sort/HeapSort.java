package com.chenxi.algorithm.demo.sort;

/**
 * 堆排序
 * 性质：每个结点的值都大于其左孩子和右孩子结点的值，称之为大根堆；每个结点的值都小于其左孩子和右孩子结点的值，称之为小根堆。如下图
 *
 *还有一个基本概念：查找数组中某个数的父结点和左右孩子结点，比如已知索引为i的数，那么
 *
 * 1.父结点索引：(i-1)/2（这里计算机中的除以2，省略掉小数）
 *
 * 2.左孩子索引：2*i+1
 *
 * 3.右孩子索引：2*i+2
 *
 * 所以上面两个数组可以脑补成堆结构，因为他们满足堆的定义性质：
 *
 * 大根堆：arr(i)>arr(2*i+1) && arr(i)>arr(2*i+2)
 *
 * 小根堆：arr(i)<arr(2*i+1) && arr(i)<arr(2*i+2)
 *
 *基本思想：升序用大根堆，降序就用小根堆
 *
 * 1.首先将待排序的数组构造成一个大根堆，此时，整个数组的最大值就是堆结构的顶端
 *
 * 2.将顶端的数与末尾的数交换，此时，末尾的数为最大值，剩余待排序数组个数为n-1
 *
 * 3.将剩余的n-1个数再构造成大根堆，再将顶端数与n-1位置的数交换，如此反复执行，便能得到有序数组
 *
 *
 */
public class HeapSort {

    private static void bulidHeapInsert(int []arr,int len) {

        for(int i=0;i<len;i++) {
            int currentNode=i;
            int parentNode=(currentNode-1)/2;
            while (arr[currentNode]>arr[parentNode]) {
                 swap(arr,currentNode,parentNode);
                currentNode=parentNode;
                parentNode=(currentNode-1)/2;
            }
        }
    }
    //交换数组中两个元素的值
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 构造最大堆（升序）
     * @param arr
     */
    public static  void doSort(int[] arr) {
        int len=arr.length;
        //首次建堆  找出最大值
        bulidHeapInsert(arr,len);
        while (len>1) {
            //固定最大值
            swap(arr, 0, len - 1);
            // 重新构造大根堆，剔除已排序好的
            len--;
            buidHeapify(arr, 0, len);
        }
    }



    private static void buidHeapify(int []arr,int index,int len) {
       int left=2*index+1;
       int right=2*index+2;
        while (left < len) {
            int largestIndex;
            //判断孩子中较大的值的索引（要确保右孩子在size范围之内） 取出最大的孩子节点和 父节点比较
            if (arr[left] < arr[right] && right < len) {
                largestIndex = right;
            } else {
                largestIndex = left;
            }
            //比较父结点的值与孩子中较大的值，并确定最大值的索引
            if (arr[index] > arr[largestIndex]) {
                largestIndex = index;
            }
            //如果父结点索引是最大值的索引，那已经是大根堆了，则退出循环
            if (index == largestIndex) {
                break;
            }
            //父结点不是最大值，与孩子中较大的值交换
            swap(arr, largestIndex, index);
            //将索引指向孩子中较大的值的索引
            index = largestIndex;
            //重新计算交换之后的孩子的索引
            left = 2 * index + 1;
            right = 2 * index + 2;
        }
    }

}
