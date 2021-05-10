package com.codeman.before210510.day1104;

/**
 * 28.实现strStr()
 *
 * asdywnj  yw : 3
 */
public class NO28 {
    public static void main(String[] args) {
//        int i = strStr("y2y2w222waysy2w222ydyyy2w222wnjyy2w22232w", "y2w2223");
//        System.out.println(i);
        System.out.println("y2y2w222waysy2w222ydyyy2w222wnjyy2w22232w".indexOf("y2w2223"));
    }

    private static int strStr(String haystack, String needle) {
        if (needle == null || "".equals(needle) || haystack == null || haystack.equals("")) {
            return 0;
        }
        int nLen = needle.length();
        int hLen = haystack.length();
        if (nLen > hLen) {
            return -1;
        }
        char nChar = needle.charAt(0);
        for (int i = 0; i <=  hLen- nLen;) {
            if (haystack.charAt(i) == nChar) {
                int count = equalCount(haystack.substring(i, i + nLen), needle);
                if (count == -1) {
                    return i;
                } else {
                    i += count;
                }
            } else {
                i ++;
            }
        }

        return -1;
    }

    private static int equalCount(String a, String b) {
        int result = 1;
        for (int i = 1; i < a.length(); i ++ ) {
            if (a.charAt(i) == b.charAt(i)) {
                result ++;
            } else {
                break;
            }
        }
        if (result == a.length()) {
            return -1;
        }
        return result;
    }
}
