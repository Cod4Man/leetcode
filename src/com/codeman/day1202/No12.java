package com.codeman.day1202;

/**
 * 整数转罗马数字
 */
public class No12 {
    public static void main(String[] args) {

    }

    private static String intToRoman(int num) {
        String result = "";
        switch (num) {
            case 4 : result = "IV";break;
            case 9 : result = "IX";break;
            case 40 : result = "XL";break;
            case 90 : result = "XC";break;
            case 400 : result = "CD";break;
            case 900 : result = "CM";break;
            default:
                result = otherResult(num, 1000, "M");
                break;
        }
        return result;
    }

    private static String otherResult(int num, int romanNum, String romanStr) {
        StringBuilder sb = new StringBuilder();
        int mCount = num / romanNum;
        int mYushu = num % romanNum;
        while (mCount != 0) {
            sb.append(romanStr);
            mCount--;
        }

        return sb.toString();
    }
}
