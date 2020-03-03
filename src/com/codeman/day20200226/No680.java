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
        String str = "babca";
        System.out.println(new No680().validPalindrome(str));
    }

    /**
     * 左右遍历，直至遇到不同的值，然后分别删除左右字母看是否相同
     * @param str
     * @return
     */
    public boolean validPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) == str.charAt(end)) {
                start ++;
                end --;
            } else {
                if (validPalindrome0(str.substring(start, end)) || validPalindrome0(str.substring(start + 1, end + 1))) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 左右遍历，直至遇到不同的值，然后分别删除左右字母看是否相同
     * @param str
     * @return
     */
    public boolean validPalindrome0(String str) {
        int start = 0;
        int end = str.length() - 1;
        while (start <= end) {
            if (str.charAt(start) == str.charAt(end)) {
                start ++;
                end --;
            } else {
                return false;
            }
        }
        return true;
    }

}
