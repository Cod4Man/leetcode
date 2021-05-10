package com.codeman.before210510.day20200308;

import java.util.Arrays;

/**
 * @author: zhanghongjie
 * @description: 数组中的第K个最大元素 Medium
 * @date: 2020/3/8 21:02
 * @version: 1.0
 */
public class No215 {
    public static void main(String[] args) {
        int num = 8;
        int[] nums = {3,2,1,5,6,4};
        /*for (int i = 0; i < num; i++) {
            nums[i] = (int)(Math.random() * num);
        }*/
        System.out.println(Arrays.toString(nums));
        int k = 2;
        System.out.println(k);
        System.out.println(new No215().findKthLargest(nums, k));
        System.out.println(Arrays.toString(nums));
    }

    public int findKthLargest(int[] nums, int k) {
        sort(nums, 0, nums.length - 1);
        return nums[k-1];
    }

    /**
     * 快速排序：找一个中间值，然后两边大小对换位置
     * @param arr
     * @param start0
     * @param end0
     */
    private void sort(int[] arr, int start0, int end0) {
        int start = start0;
        int end = end0;
        int mid = (start0 + end0) / 2;
        int midValue = arr[mid];
        while (start < end) {
            while (arr[start] > midValue) {
                start ++;
            }
            // 以上，找到左边不小于中间大的值
            while (midValue > arr[end]) {
                end --;
            }
            // 以上，找到右边小于中间大的值
            if (start >= end) {
                break;
            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                if (arr[start] == midValue) end--;
                if (arr[end] == midValue) start++;

            }
        }
        if (start == end) {
            start ++;
            end --;
        }


        if (start0 < end) {
            sort(arr, start0, end);
        }

        if (end0 > start) {
            sort(arr, start, end0);
        }


    }
}
