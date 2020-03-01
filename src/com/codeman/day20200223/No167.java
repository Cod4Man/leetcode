package com.codeman.day20200223;

/**
 * @author: zhanghongjie
 * @description: 双指针：有序数组的 Two Sum(Easy)
 * @date: 2020/2/23 22:35
 * @version: 1.0
 */
public class No167 {
    public static void main(String[] args) {
        int[] numbers = {2, 4, 5, 11};
        twoSum(numbers, 9);
    }

    public static int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                end --;
            } else if (sum < target) {
                start ++;
            }

        }
        return null;
    }


    /**
     * 加上二分查找
     * @param numbers  2, 4, 5, 11，13，21   =24
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                return new int[]{start + 1, end + 1};
            } else if (sum > target) {
                end --;
            } else if (sum < target) {
                start ++;
            }

        }
        return null;
    }
}
