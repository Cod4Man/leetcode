package com.codeman.day20200226;

/**
 * @author: zhanghongjie
 * @description: 345.反转字符串中的元音字符 (Easy)
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * @date: 2020/2/26 21:35
 * @version: 1.0
 */
public class No345 {
    public static void main(String[] args) {
        No345 no345 = new No345();
        String str = "hello world";
        System.out.println(str);
        System.out.println(no345.reverseVowels(str));
    }

    /**
     * 元音字母：a e i o u
     * 思路：可以使用双指针，从头尾开始遍历，然后一一交换
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        char[] sChar = s.toCharArray();
        int start = 0;
        int end = sChar.length - 1;
        while (true) {
            while (start < end && isNotYuanYin(sChar[start])) {
                start ++;
            }
            while (start < end && isNotYuanYin(sChar[end])) {
                end --;
            }
            if (start < end) {
                char temp = sChar[start];
                sChar[start] = sChar[end];
                sChar[end] = temp;
                start ++;
                end --;
            } else {
                break;
            }
        }
        return new String(sChar);
    }

    private boolean isNotYuanYin(char charAt) {
        return !(charAt == 'a' || charAt == 'e' || charAt == 'i' || charAt == 'o' || charAt == 'u' ||
                charAt == 'A' || charAt == 'E' || charAt == 'I' || charAt == 'O' || charAt == 'U'
        );
    }
}
