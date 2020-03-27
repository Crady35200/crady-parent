package com.crady.jdk8;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author :Crady
 * date :2019/12/11 11:05
 * desc : JDK1.8新日期API
 **/
public class DateDemo {

    private static final String DATE_FORMAT = "YYYY-MM-dd HH:mm:ss";
    public static void main(String []args){
        dateTimeFormat();
        dateTimeFormatter();
        now();
    }

    /**
     * 传统的API，SimpleDateFormat线程不安全
     */
    public static void dateTimeFormat(){
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        String d = format.format(new Date());
        System.out.println("**************dateTimeFormat***************" + d);
    }

    /**
     * jdk1.8新API线程安全
     */
    public static void dateTimeFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        String s = formatter.format(LocalDateTime.now());
        System.out.println("**************DateTimeFormatter***************" + s);
    }

    public static void now(){
        System.out.println("获取当前时间方式：");
        System.out.println("*******************new Date()************" + new Date());
        System.out.println("*******************Instant.now()************" + Instant.now());
        System.out.println("*******************LocalDate.now()************" + LocalDate.now());
        System.out.println("*******************LocalTime.now()************" + LocalTime.now());
        System.out.println("*******************LocalDateTime.now()************" + LocalDateTime.now());
    }

}
