package com.crady.algorithm.example;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author: Crady
 * date: 2022/8/3 11:49
 * desc:给你一个字符串数组words。words中每个元素都是一个包含 两个小写英文字母的单词。
 *
 * 请你从 words中选择一些元素并按 任意顺序连接它们，并得到一个 尽可能长的回文串。每个元素 至多只能使用一次。
 *
 * 请你返回你能得到的最长回文串的 长度。如果没办法得到任何一个回文串，请你返回 0。
 *
 * 回文串指的是从前往后和从后往前读一样的字符串。
 *
 * 示例 1：
 *
 * 输入：words = ["lc","cl","gg"]
 * 输出：6
 * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
 * "clgglc" 是另一个可以得到的最长回文串。
 * 示例 2：
 *
 * 输入：words = ["ab","ty","yt","lc","cl","ab"]
 * 输出：8
 * 解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
 * "lcyttycl" 是另一个可以得到的最长回文串。
 * 示例 3：
 *
 * 输入：words = ["cc","ll","xx"]
 * 输出：2
 * 解释：最长回文串是 "cc" ，长度为 2 。
 * "ll" 是另一个可以得到的最长回文串。"xx" 也是。
 * 
 *
 * 提示：
 *
 * 1 <= words.length <= 105
 * words[i].length == 2
 * words[i]仅包含小写英文字母。
 *
 **/
public class LongestPalindrome {

    public static void main(String[] args) {
//        String [] words = {"ab","ty","yt","lc","cl","ab"};
        String [] words = {"lc","cl","gg"};
        LongestPalindrome longestPalindrome = new LongestPalindrome();
//        System.out.println(longestPalindrome.longestPalindrome(words));
        System.out.println(longestPalindrome.longestPalindromeBest(words));
    }

    public int longestPalindromeBest(String[] words) {
        if (words == null || words.length < 1) {
            return 0;
        }
        int n = 0;
        int k = 0;
        int [][] array = new int[26][26];
        for (int i = 0; i < words.length; i++) {
            array[words[i].charAt(0) - 'a'][words[i].charAt(1) - 'a']++;
        }


        for (int i = 0; i < array.length; i++) {
            for (int j = i; j < array.length; j++) {
                if (i == j) {
                    n += (array[i][i] >> 1) << 2;
                    if ((array[i][i] & 1) == 1) {
                        k = 2;
                    }
                } else {
                    n += Math.min(array[i][j], array[j][i]) * 4;
                }
            }
        }
        return n + k;

    }


    public int longestPalindrome(String[] words) {

            if (words == null || words.length < 1) {
                return 0;
            }
            int len = words.length;
            int n = 0;
            boolean repeatStr = false;
            Set<Integer> sets = new HashSet<>();
            for (int i = 0; i < len; i++) {
                if (sets.contains(i)) {
                    continue;
                }
                for (int j = i+1; j < len; j++) {
                    if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1)== words[j].charAt(0) && !sets.contains(j)){
                        n += 4;
                        sets.add(j);
                        sets.add(i);
                        break;
                    }
                }
                if (!repeatStr && words[i].charAt(0) == words[i].charAt(1) && !sets.contains(i)){
                    repeatStr = true;
                }
            }
            n += repeatStr ? 2 : 0;
            return n;
    }
}
