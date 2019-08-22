package com.crady.algorithm;

/**
 * @author :Crady
 * date :2019/8/22 9:42
 * desc :
 **/
public class Algorithm2 {

    public static void main(String[] args) {
        String s1 = "abcba";
        System.out.println(s1 + ":" + isHuiWen(s1));

        String s2 = "";
        System.out.println(s2 + ":" + isHuiWen(s2));

        String s3 = "abcbad";
        System.out.println(s3 + ":" + isHuiWen(s3));

        String s4 = "abcbcba";
        System.out.println(s4 + ":" + isHuiWen(s4));
    }

    /**
     * 时间复杂度O(n/2)，空间复杂度O(1)
     * 思路：遍历列表的一半，然后使用正序指针和逆序指针对比，如果都一样则是回文，否则不是
     * @param str
     * @return
     */
    public static boolean isHuiWen(String str){
        if(str == null || str.length() < 1){
            return true;
        }
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if(str.charAt(i) != str.charAt(len -1 - i)){
                return false;
            }
        }
        return true;
    }

}
