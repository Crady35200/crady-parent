package com.crady.algorithm.example;

/**
 * @author :Crady
 * date :2022/06/25 00:23
 * desc :给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class NoRepeatMaxLengthSubString {

    public static void main(String[] args) {

        getMaxSubStringLength("pwwkew");
        getMaxSubStringLength("");
        getMaxSubStringLength("eeee");

    }

    public static int getMaxSubStringLength(String s) {
        int max = 0;
        if (s == null){
            max = 0;
        }
        for (int i = 0; i < s.length(); i++) {
            int n = 1;
            for (int j = i + 1; j < s.length(); j++) {
                String str = s.substring(i, j);
                if (str.contains(s.substring(j, j + 1))) {
                    break;
                }
                n++;
            }
            max = max < n ? n : max;
        }
        System.out.println(max);
        return max;
    }

}
