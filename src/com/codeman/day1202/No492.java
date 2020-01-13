package com.codeman.day1202;

import java.util.Arrays;

/**
 * 构造矩形：
 * 长>=宽
 * 长-宽最小
 */
public class No492 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(test(11)));
    }

    private static int[] test(int s) {
        int[] result = new int[2];
        int sqrS = (int) Math.sqrt(s);
        if (sqrS * sqrS == s) {
            result[0]= sqrS;
            result[1]= sqrS;
        } else {
            for (int l = sqrS + 1; l < s; l ++) {
                if (s % l == 0) {
                    result[0] = l;
                    result[1] = s / l;
                    break;
                }
            }
        }
        return result;
    }
}
