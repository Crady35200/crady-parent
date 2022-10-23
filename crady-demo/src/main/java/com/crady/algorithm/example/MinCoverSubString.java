package com.crady.algorithm.example;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author: Crady
 * date: 2022/10/24 01:00
 * desc:  https://leetcode.cn/problems/minimum-window-substring/
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 示例 1：
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 **/
public class MinCoverSubString {

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t="ABC";
        String result = new MinCoverSubString().minWindow(s, t);
        System.out.println(result);
    }

    public String minWindow(String s, String t) {

        if(s == null || t == null) {
            return "";
        }
        int len = s.length();
        int tLen = t.length();
        int l=0,r=0;
        int left=0;
        int min=Integer.MAX_VALUE;
        HashMap<Character, Integer> sHash = new HashMap<>();
        HashMap<Character, Integer> tHash = new HashMap<>();
        for(int i =0; i<tLen; i++){
            tHash.put(t.charAt(i), tHash.getOrDefault(t.charAt(i),0)+1);
        }
        if(tHash.containsKey(s.charAt(r))){
            sHash.put(s.charAt(r), sHash.getOrDefault(s.charAt(r),0) + 1);
        }

        while(r < len && l <= len) {
            boolean flag = true;
            Iterator iter = tHash.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry) iter.next();
                Character key = (Character) entry.getKey();
                Integer val = (Integer) entry.getValue();
                if (sHash.getOrDefault(key, 0) < val) {
                    flag = false;
                }
            }

            if(flag) {
                if(r -l +1 < min) {
                    min=r - l + 1;
                    left = l;
                }
                if(tHash.containsKey(s.charAt(r))){
                    sHash.put(s.charAt(l), sHash.getOrDefault(s.charAt(l),0) - 1);
                }
                l++;
            }else {
                r++;
                if(r < len && tHash.containsKey(s.charAt(r))) {
                    sHash.put(s.charAt(r), sHash.getOrDefault(s.charAt(r),0) + 1);
                }

            }
        }

        if(min == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(left, left + min);
        }

    }
}
