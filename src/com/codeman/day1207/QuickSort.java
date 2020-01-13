package com.codeman.day1207;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {
    public static void main(String[] args) {
        int num = 38888888;
        int[] arr = new int[num];
        for (int i = 0; i < num; i++) {
            arr[i] = (int) (Math.random() * num);
        }
//        System.out.println(Arrays.toString(arr));
        long bef = System.currentTimeMillis();
        sort(arr, 0, arr.length - 1);
        System.out.println("排序花费时间：" + (System.currentTimeMillis() - bef));
//        System.out.println(Arrays.toString(arr));
    }

    // 1 -5 22 0 23 -2 -3
    // -3 -5 22 0 23 -2 1 左右指针都移动
    // -3 -5 -2 0 23 22 1
    // ================
    // 1 2 3 10 23 -5 13
    // 1 2 3 -5 23 10 13  等于中间值的一方不动
    // 1 2 3 -5 10 23 13 此时中间值10两端的数都分别再两侧，需要分别对两侧的数据进行上诉操作，但是中间值可以不包含在内，因此需要++,--

    public static void sort(int[] arr, int left, int right) {
        int lP = left; // 左指针
        int rP = right; // 右指针
        int midValue = arr[(lP + rP) / 2]; // 中间值，以此为基准

        //循环遍历数据，
        while (lP < rP) { // 当左指针>=右指针，则说明数组遍历完成

            // 左边找到第一个小于=中间值的数
            while (arr[lP] < midValue) {
                lP ++;
            }

            // 右边找到第一个大于=中间值的数
            while (arr[rP] > midValue) {
                rP --;
            }
            // 当左指针>=右指针，则说明数组遍历完成，无需后续的多余交换
            if (lP == rP) {
                break;
            }

            // 一定会找到，至少会找到中间值
            // 然后进行交换元素
            int temp = arr[lP];
            arr[lP] = arr[rP];
            arr[rP] = temp;
//            System.out.println(Arrays.toString(arr));
            // 等于中间值的一方不做移动，这样才能在需要交换时进行交换，否则指针变了就找不到中间值所在下标了
            if (arr[lP] == midValue) {
                rP --;
            }
            if (arr[rP] == midValue) {
                lP ++;
            }
        }
        // 中间值不需要进行递归
        if (lP == rP) {
            lP ++;
            rP --;
        }

        // 递归左右两端，直至有序
        // 什么时候有序？ --
        // 左半部分递归
        if (left < rP) {
            sort(arr, left, rP);
        }
        // 右半部分递归
        if (right > lP) {
            sort(arr, lP, right);
        }
    }
}
