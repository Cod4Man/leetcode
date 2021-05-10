package com.codeman.before210510.day20200226;

import java.util.Arrays;

/**
 * @author: zhanghongjie
 * @description:
 * @date: 2020/3/3 23:02
 * @version: 1.0
 */
public class No88 {

    public static void main(String[] args) {
        int[] nums1 = {0};
        int m  = 0;
        int[] nums2 = {1};
        int n = 1;
        System.out.println(Arrays.toString(nums1));
        new No88().merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp = nums1.length - 1;
        m--;
        n--;
        while (m >=0 && n >=0) {
            if (nums1[m] > nums2[n]) {
                nums1[temp--] = nums1[m--];
            } else if (nums1[m] == nums2[n]) {
                nums1[temp--] = nums1[m--];
                nums1[temp--] = nums2[n--];
            } else {
                nums1[temp--] = nums2[n--];
            }
        }
        // m大无需移动
        if (n >= 0) {
            for (int i = n; i >= 0; i--) {
                nums1[i] = nums2[i];
            }
        }
    }
}
