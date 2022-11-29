package com.crady.algorithm.example;

/**
 * @author :Crady
 * date :2022/06/25 00:23
 * desc :给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 **/
public class NoRepeatMaxLengthSubString {

    public static void main(String[] args) {

        System.out.println("*********getMaxSubStringLength**********");
        System.out.println(getMaxSubStringLength("abcabcbb"));
        System.out.println(getMaxSubStringLength("pwwkew"));
        System.out.println(getMaxSubStringLength(""));
        System.out.println(getMaxSubStringLength("eeee"));

        System.out.println("*********maxSubString**********");
        System.out.println(maxSubString("abcabcbb"));
        System.out.println(maxSubString("pwwkew"));
        System.out.println(maxSubString(""));
        System.out.println(maxSubString("eeee"));

    }

    public static int getMaxSubStringLength(String s) {

        if (s == null || s.length() < 1){
            return 0;
        }
        int max = 1;
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
        return max;
    }

    public static int maxSubString(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }
        int len = s.length();
        int max = 1;
        String str = "";
        int i=0,j=0;
        while(i<len && j<len) {
            String tmp = "" + s.charAt(j);
            if (str.contains(tmp)) {
                str = "";
                i++;
                j=i;
            }else{
                max = Math.max(max,j-i + 1);
                str = str + tmp;
                j++;
            }
        }
        return max;
    }

}
