package com.codeman.day20200226;

/**
 * @author: zhanghongjie
 * @description:
 * @date: 2020/3/3 23:02
 * @version: 1.0
 */
public class No88 {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 7, 9, 0, 0, 0};
        int m  = 3;
        int[] nums2 = {2, 8, 9};
        int n = 3;
        new No88().merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int mp = 0;
        int np = 0;
        int temp = 0;
        while (np <= n || mp <= m) {
            if (nums1[mp] > nums2[np]) {
                temp = nums1[mp];
                nums1[mp] = nums2[np];
            }
        }
    }
}
