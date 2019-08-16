package com.crady.util;

import java.util.Arrays;

/**
 * @author :Crady
 * date :2019/8/13 10:00
 * desc : 字符串操作工具类
 **/
public class StringUtil {

    public static void main(String[] args) {
        System.out.println(StrToBinstr("ming"));
        System.out.println(BinstrToStr("01101101 01101001 01101110 01100111"));
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

    /**
     * 把String转为二进制，且每个字符不足8位，高位补0，生成的二进制各个字符以空格相隔
     * @param str
     * @return
     */
    public static String StrToBinstr(String str) {
        char[] strChar = str.toCharArray();
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = 0; i < strChar.length; i++) {
            String s = Integer.toBinaryString(strChar[i]) + "";
            while(s != null && s.length() < 8){
                s = "0" + s;
            }
            stringBuilder.append(s);
            stringBuilder.append(" ");//各个字符以空格相隔
        }
        return stringBuilder.toString();
    }

    /**
     * 二进制字符串(以空格区分)转为实际字符串
     * @param binStr
     * @return
     */
    public static  String BinstrToStr(String binStr) {
        String[] tempStr = binStr.split(" ");
        char[] tempChar = new char[tempStr.length];
        for (int i = 0; i < tempStr.length; i++) {
            tempChar[i] = BinstrToChar(tempStr[i]);
        }
        System.out.println("------tempChar=" + Arrays.toString(tempChar));
        return String.valueOf(tempChar);
    }

    // 将二进制字符串转换为char
    public static  char BinstrToChar(String binStr) {
        int[] temp = BinstrToIntArray(binStr);
        int sum = 0;
        for (int i = 0; i < temp.length; i++) {
            sum += temp[temp.length - 1 - i] << i;
        }
        return (char) sum;
    }

    // 将二进制字符串转换成int数组
    public static  int[] BinstrToIntArray(String binStr) {
        char[] temp = binStr.toCharArray();
        int[] result = new int[temp.length];
        for (int i = 0; i < temp.length; i++) {
            result[i] = temp[i] - 48;
        }
        return result;
    }
}
