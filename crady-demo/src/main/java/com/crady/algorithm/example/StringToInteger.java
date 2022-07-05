package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/7/5 21:26
 * desc:请你来实现一个函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 *
 * 函数myAtoi(string s) 的算法如下：
 *
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31− 1 的整数应该被固定为 2^31− 1 。
 * 返回整数作为最终结果。
 * 注意：
 *
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 **/
public class StringToInteger {

    public static void main(String[] args) {

        String s = " +42";
        int result = new StringToInteger().stringToInt(s);
        System.out.println(result);
    }

    public int stringToInt(String s) {
        if (s == null || s.trim().equals("")) {
            return 0;
        }
        s = s.trim();
        int isPositive = s.charAt(0) == '-' ? -1 : 1;
        s = isPositive > 0 && s.charAt(0) != '+' ? s : s.substring(1);
        boolean flag = false;
        int result = 0;
        char [] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];

            if (ch == '0' && !flag) {
                continue;
            }
            flag = true;
            if (!Character.isDigit(ch)) {
                break;
            }
            int n = ch - '0';
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && n > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            } else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && -n < Integer.MIN_VALUE % 10)) {
                return Integer.MIN_VALUE;
            }
            result = result * 10 + n * isPositive;
        }

        return result;

    }

}
