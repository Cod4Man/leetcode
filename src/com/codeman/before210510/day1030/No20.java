package com.codeman.before210510.day1030;

/**
 * LeetCode 20.有效的括号
 */
public class No20 {

    public static void main(String[] args) {
        boolean test = test("[2(222333333{33((2{)2)2323asd}3)]");
        System.out.printf("test======" + test);
    }

    private static boolean test(String str) {
        boolean result = true;
        // 思路：头尾同时遍历，遍历到括号就停下进行判断，符号不相同则return false

        int point = 0;
        int j = j = str.length() - 1;
        aa:for (int i = 0; i < str.length() && i < j; i ++) {
            if (checkCharLeft(str.charAt(i)) == 0 && checkCharRight(str.charAt(i)) == 0) {
                continue;
            }
            if (checkCharRight(str.charAt(i)) != 0) {
                result = false;
                break aa;
            }
            for (; j > i ; j --) {
                if (checkCharLeft(str.charAt(j)) == 0 && checkCharRight(str.charAt(j)) == 0) {
                    continue;
                }
                if (checkChar(str.charAt(i), str.charAt(j))) {
                    j--;
                    break;
                } else {
                    result = false;
                    break aa;
                }
            }
        }

        return result;
    }

    /**
     *
     * @param chaLeft
     * @param chaRight
     * @return
     */
    private static boolean checkChar(char chaLeft, char chaRight) {
        return chaLeft == checkCharRight(chaRight);
    }

    private static char checkCharLeft(char cha) {
        char result = 0;
        switch (cha) {
            case '[': result = ']'; break;
            case '{': result = '}'; break;
            case '(': result = ')'; break;
            default: result = 0; break;
        }
        return result;
    }

    private static char checkCharRight(char cha) {
        char result = 0;
        switch (cha) {
            case ']': result = '['; break;
            case '}': result = '{'; break;
            case ')': result = '('; break;
            default: result = 0; break;
        }
        return result;
    }
}
