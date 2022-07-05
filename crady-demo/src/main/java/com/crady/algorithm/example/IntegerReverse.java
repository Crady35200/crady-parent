package com.crady.algorithm.example;

/**
 * @author: Crady
 * date: 2022/7/6 01:47
 * desc:给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围[−2^31, 2^31− 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 **/
public class IntegerReverse {

    public static void main(String[] args) {
        int n = -123;
        int res = new IntegerReverse().integerReverse(n);
        System.out.println(res);
    }

    public int integerReverse(int n) {

        String s = String.valueOf(n);
        int isPositive = s.charAt(0) == '-' ? -1 : 1;
        s = isPositive > 0 && s.charAt(0) != '+' ? s : s.substring(1);
        char [] chs = s.toCharArray();
        boolean flag = false;
        int result = 0;
        for (int i = chs.length - 1; i >= 0; i--) {
            if (chs[i] == '0' && !flag) {
                continue;
            }
            flag = true;
            int m = chs[i] - '0';
            boolean isBigger = result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && m > Integer.MAX_VALUE % 10);
            boolean isSmaller = result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && m < Integer.MIN_VALUE % 10);
            if (isBigger || isSmaller) {
                return 0;
            }

            result = result * 10 + isPositive * m;

        }
        return result;
    }

}
