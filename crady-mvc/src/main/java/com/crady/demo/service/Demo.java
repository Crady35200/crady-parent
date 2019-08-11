package com.crady.demo.service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * author:Crady
 * date:2019/08/10 17:57
 * desc:
 **/
public class Demo {
    public static void main(String[] args) {
        String s = "/user/login/.*";
        Pattern pattern = Pattern.compile(s);
        String str = "/user/login/a";
        System.out.println(pattern.matcher(str).matches());

        Pattern p = Pattern.compile("a*");
        Matcher m = p.matcher("aaaaab");
        boolean b = m.matches();
        System.out.println("b=" + b);
    }

}
