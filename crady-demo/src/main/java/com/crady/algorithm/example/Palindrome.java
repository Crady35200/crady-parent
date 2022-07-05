package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/7/3 19:06
 * desc: 给你一个字符串 s，找到 s 中最长的回文子串。
 **/
public class Palindrome {

    public static void main(String[] args) {

        String s = "bb";
        String result = new Palindrome().longestPalindrome(s);
        System.out.printf(result);

    }

    public String longestPalindrome(String s) {

        if (s == null || "".equals(s)) {
            return null;
        }
        if (s.length() < 2) {
            return s;
        }
        // 初始化等于1的情况
        char[] chars = s.toCharArray();
        int len = chars.length;
        boolean [] [] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        int index = 0;
        int maxLength = 1;
        for (int l = 2; l <= len; l++) {
            for (int i = 0; i < len; i++) {
                int j = i + l - 1;
                if (j >= len) {
                    break;
                }
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                }else {
                    if (j - i < 2) {
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if (dp[i][j] && j - i + 1 > maxLength) {
                    maxLength = j - i + 1;
                    index = i;
                }
            }
        }
        return s.substring(index, index + maxLength);

    }
}
