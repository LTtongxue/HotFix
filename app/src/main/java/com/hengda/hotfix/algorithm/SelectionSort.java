package com.hengda.hotfix.algorithm;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {5, 8, 6, 3, 9, 2, 1, 7, 10};
        sort(arr);
        System.out.print(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {//找到最小的数
                    minIndex = j;//将最小数的索引保存
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
}
