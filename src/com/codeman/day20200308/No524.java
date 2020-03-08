package com.codeman.day20200308;

import java.util.*;

/**
 * @author: zhanghongjie
 * @description: 通过删除字母匹配到字典里最长单词 (Medium)
 * 给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。
 * 如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
 * @date: 2020/3/8 14:46
 * @version: 1.0
 */
public class No524 {
    public static void main(String[] args) {
        // ["ale","apple","monkey","plea"]
        System.out.println(new No524().findLongestWord("apdapsle", new ArrayList<>(Arrays.asList("ale", "apple", "monkey", "plea"))));
//        System.out.println(new No524().findLongestWord("abcd", new ArrayList<>(Arrays.asList("b", "a", "c", "d"))));
//        System.out.println(new No524().findLongestWord("bab", new ArrayList<>(Arrays.asList("ba","ab","a","b"))));
//        System.out.println(new No524().isAllowWord("aadpasdpadle", "apple"));
    }

    public String findLongestWord0(String s, List<String> d) {
        if (d == null || d.isEmpty() || s == null || s.length() == 0) return "";
        // 虽然用到了两次排序，减少代码量，但是两次排序已经进行了多次遍历，费时，还不如直接从头遍历，最坏的情况也才一轮遍历
        Collections.sort(d);
        d.sort((o1, o2)-> {
            return o2.length() - o1.length();
        });
        for (int i = 0; i < d.size(); i++) {
            if (isAllowWord(s, d.get(i))) {
                return d.get(i);
            }
        }
        return "";
    }

    public String findLongestWord(String s, List<String> d) {
        if (d == null || d.isEmpty() || s == null || s.length() == 0) return "";
        String result = "";
        int maxLength = 0;
        for (int i = 0; i < d.size(); i++) {
            String s1 = d.get(i);
            if (s.length() < s1.length() || !isAllowWord(s, d.get(i))) {
                continue;
            }
            if (s1.length() > maxLength) {
                maxLength = s1.length();
                result = s1;
            } else if (s1.length() == maxLength && s1.compareTo(result) < 0) {
                result = s1;
            }
        }
        return result;
    }

    private boolean isAllowWord(String s, String d) {
        char[] chars = s.toCharArray();
        char[] chars1 = d.toCharArray();
        int sStr = 0;
        int dStr = 0;
        for (; dStr < chars1.length && sStr < chars.length; sStr++) {
            if (chars[sStr] == chars1[dStr]) {
                dStr ++;
            }
        }
        return dStr == chars1.length;
    }
}
