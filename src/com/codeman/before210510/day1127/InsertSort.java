package com.codeman.before210510.day1127;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
//        int[] arr = {22, 2, -5, 0, 23, 11, 15};
        int num = 88;
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * num);
        }
        System.out.println(Arrays.toString(arr));
        long bef = System.currentTimeMillis();
//        insertSort(arr);
        shellSort(arr);
        System.out.printf("排序一共耗时：%s(ms)",System.currentTimeMillis() - bef);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 原理：将数组分为两个序列，一半是有序，一半是无序，无序挨个插入有序的相应位置
     * 22, 2, -5, 23, 11, 15
     * 2, 22, -5, 23, 11, 15
     * -5, 2, 22, 23, 11, 15
     * @param arr
     */
    private static int[] insertSort(int[] arr) {

        // 第一个必定有序，所以从第二个开始插入
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i]; // 记录被转移值
            int tempIndex = i; // 指针
            while (tempIndex - 1 >= 0 && temp < arr[tempIndex - 1]) {
                arr[tempIndex] = arr[tempIndex - 1]; // 后移
                tempIndex--;
            }
            // 插入被转移值
            if (tempIndex != i) {
                arr[tempIndex] = temp;
            }
        }
        return arr;
    }

    public static int[] shellSort(int[] arr) {
        for (int grp = arr.length / 2; grp > 0; grp /= 2) { // 分组
            for (int i = grp; i < arr.length; i ++) { // 嵌套插入排序，从第二个数开始,在做插入排序是不是一组一组，而是所有组一次排序2、3、4...个
                int temp = arr[i]; // 记录被转移值
                int tempIndex = i; // 指针
                while (tempIndex - grp >= 0 && temp < arr[tempIndex - grp]) { // grp 为组中每个元素的间隔
                    arr[tempIndex] = arr[tempIndex - grp]; // 后移
                    tempIndex-= grp;
                }
                // 插入被转移值
                if (tempIndex != i) {
                    arr[tempIndex] = temp;
                }
            }

        }
        return arr;
    }
}
