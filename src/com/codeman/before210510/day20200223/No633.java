package com.codeman.before210510.day20200223;

/**
 * @author: zhanghongjie
 * @description: 633. 平方数之和(EASY)
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c。
 * @date: 2020/2/23 22:59
 * @version: 1.0
 */
public class No633 {
    public static void main(String[] args) {
        boolean result = result(5);
        System.out.println(result);
    }


    private static boolean result(int target) {
        int start = 1;
        int end = (int) Math.sqrt(target);
        if (end * end == target) {
            return true;
        }
        while (start < end) {
            int sum = start * start + end * end;
            if (sum == target) {
                return true;
            } else if (sum > target) {
                end --;
            } else {
                start ++;
            }

        }
        return false;
    }


    /**
     * 费马平方和定理告诉我们：
     *
     *     一个非负整数 ccc 能够表示为两个整数的平方和，当且仅当 ccc 的所有形如4k+3的质因子的幂次均为偶数。
     *
     * @param c
     * @return
     */
    public static boolean judgeSquareSum(int c) {
        for (int i = 2; i * i <= c; i++) {
            int count = 0;
            if (c % i == 0) {
                while (c % i == 0) {
                    count++;
                    c /= i;
                }
                if (i % 4 == 3 && count % 2 != 0)
                    return false;
            }
        }
        return c % 4 != 3;
    }
}
