package com.hengda.hotfix.algorithm;

import java.util.Arrays;

//冒泡排序
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7};
        sort2(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void sort(int arr[]) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    //优化版1
    private static void sort1(int arr[]) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            //有序标记,每一轮的初始是true
            boolean isSort = true;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //有元素交换,所以不是有序,标记变为false
                    isSort = false;
                }
            }
            if (isSort) {
                break;
            }
        }
    }

    //优化版2
    private static void sort2(int arr[]) {
        int temp = 0;
        //记录最后一次交换的位置
        int lastExchangeIndex = 0;
        //无序数列的边界,每次比较只需要比到这里为止
        int sortBorder = arr.length - 1;
        for (int i = 0; i < arr.length; i++) {
            //有序标记,每一轮的初始是true
            boolean isSort = true;
            for (int j = 0; j < sortBorder; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    //有元素交换,所以不是有序,标记变为false
                    isSort = false;
                    //把无序数列的边界更新为最后一次交换元素的位置
                    lastExchangeIndex = j;
                }
            }
            sortBorder = lastExchangeIndex;
            if (isSort) {
                break;
            }
        }
    }
}
