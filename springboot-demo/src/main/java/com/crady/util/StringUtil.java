package com.crady.util;

/**
 * @author :Crady
 * date :2019/8/13 10:00
 * desc : 字符串操作工具类
 **/
public class StringUtil {

    public static void main(String[] args) {
        System.out.println(isEmpty(""));
    }

    /**
     * 判断字符串是否为不为null或者""
     * @param str
     * @return 字符串不为空则返回true否则返回false
     */
    public static boolean isNotEmpty(String str){
        return (str != null && !"".equals(str.trim()));
    }

    /**
     * 判断字符串是否为为null或者""
     * @param str
     * @return 字符串为空则返回true否则返回false
     */
    public static boolean isEmpty(String str){
        return (str == null || "".equals(str.trim()));
    }
}
