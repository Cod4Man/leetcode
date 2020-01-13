package com.codeman.day1101;

/**
 * 191.位为1的个数
 */
public class No191 {
    public static void main(String[] args) {
//        System.out.println(test(1023));
        test2(1);
    }

    /**
     * 优解. 关键点 n & (n-1) 会将n的末尾1变成0
     * @param i
     */
    private static void test2(int i) {
        int sum = 0;
        while (i != 0) {
            i &= i-1;
            sum++;
        }
        System.out.println("sum=" + sum);
    }

    private static int test(int x) {
        int res = 0;
        aa:for (int n = 1; x >= (int)Math.pow(2,n-1) -1; n ++) {
            boolean b = false;
            for (int m=0; x >= 2*m -1; m++) {
                b = isOne(x, m, n);
                if (b) {
                    res ++;
                }
            }
        }
        return res;
    }
    private static boolean isOne(int x, int m, int n) {
        boolean result = false;
        if (x >= (2*m+1) * ((int)Math.pow(2,n-1)) && x <= ((1+m) * (int)Math.pow(2,n) -1)) {
            result = true;
        }
        return result;
    }
}
