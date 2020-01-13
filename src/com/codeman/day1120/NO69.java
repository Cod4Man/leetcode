package com.codeman.day1120;

/**
 * 实现Math.sqrt(),保留整数部分
 */
public class NO69 {
    public static void main(String[] args) {
        for (int num = 1; num <= 36; num ++) {
            int result = mySqrt(num);
            System.out.printf("num=【%s】\n", num);
            System.out.printf("%s * %s = %s\n", result, result, result * result);
            System.out.printf("%s * %s = %s\n", result+1, result+1, (result+1) * (result+1));
            System.out.println("===============================");
        }
    }

    private static int mySqrt(int num) {
        return halfFind2(num);
    }

    private static int halfFind2(int num) {
return 0;
    }

    // 二分查找
    private static int halfFind(int num, int start, int end) {
        if (start * start == num) {
            return start;
        }
        if (end * end == num) {
            return end;
        }
        if (start == end) {
            if (start * start < num)
            return start;
            return start - 1;
        }
        double mid = (start + end) / 2.0;
        if (mid * mid == num) {
            return (int) mid;
        } else if (mid * mid < num) {
            start = (int) mid + 1;
            return halfFind(num, start, end);
        } else{ // mid * mid > num
            end = (int) mid;
            return halfFind(num, start, end);
        }

    }

}
