package com.codeman;

import javax.jws.Oneway;

/**
 * @author: zhanghongjie
 * @description: 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * <p>
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sqrtx
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 2021/5/10 23:31
 * @version: 1.0
 */
public class No69_x的平方根 {
    public static void main(String[] args) {
        for (int i = 1; i < 102; i++) {
            System.out.print(i + "\t");
            System.out.println(new No69_x的平方根().mySqrt2(i));
        }
        System.out.println(new No69_x的平方根().mySqrt2(2147395599));
    }

    /**
     * 思路：
     * 1. x的平方根一定<=x/2
     * 2. (]取right, 其余取left
     * 3. 采用二分查找提高效率
     * 1 1
     * 2 1
     * 3 1
     * 4 2
     * 5 2
     * 6 2
     * 7 2
     * 8 2
     * 9 3
     * 10 3
     * 11 3
     * 12 3
     * 13 3
     * 14 3
     * 15 3
     * 16 4
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 0) return 0;
        long right = (x >> 1) + 1;
        long left = 1;
        if (right * right == x) return (int) right;
        long mid = (left + right) >> 1;
        for (;;) {
            // 二分查找，每次只比较新的值，命名为newHalfX
            if (left > right) return -1;
            long temp = mid * mid;
            if (temp == x) return (int) mid;
            if (left + 1 == right) return (int) left;
            if (temp < x) {
                left = mid;
                mid = (left + right) >> 1;
                continue;
            }
            right = mid;
            mid = (left + right) >> 1;
        }
    }

    /**
     * 优化，使用除法，而不是乘法，防止溢出
     * @param x
     * @return
     */
    public int mySqrt2(int x) {
        if (x == 0) return 0;
        int right = (x >> 1) + 1;
        int left = 1;
        if (x / right  == right) return right;
        int mid = (left + right) >> 1;
        for (;;) {
            // 二分查找，每次只比较新的值，命名为newHalfX
            if (left > right) return -1;
            if (x / mid == mid) return mid;
            if (left + 1 == right) return left;
            if (x / mid > mid) {
                left = mid;
                mid = (left + right) >> 1;
                continue;
            }
            right = mid;
            mid = (left + right) >> 1;
        }
    }


    public int mySqrt_others01(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
