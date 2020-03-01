package com.codeman.day20200226;

/**
 * @author: zhanghongjie
 * @description: 验证回文字符串 Ⅱ （EASY）
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 * @date: 2020/2/26 22:09
 * @version: 1.0
 */
public class No680 {
    public static void main(String[] args) {
        String str = "";
        System.out.println(new No680().validPalindrome(str));
    }

    /**
     * 和345其实是同一个题型，只需要前后遍历，直至不相同
     * 情况一：如果不相等了，但是下一个数又相同，则继续
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        return false;
    }
}
