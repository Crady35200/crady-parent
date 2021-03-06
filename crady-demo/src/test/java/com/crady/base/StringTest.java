package com.crady.base;

import org.junit.Test;

/**
 * @author :Crady
 * date :2019/11/14 10:05
 * desc : 字符串常量测试
 **/
public class StringTest {

    /**
     * 两个字符串常量比较
     * 直接使用双引号声明出来的String对象会直接存储在常量池中
     * 采用字面值的方式创建一个字符串时，JVM首先会去字符串池中查找是否存在"abc"这个对象，
     * 如果不存在，则在字符串常量池中创建"abc"这个对象，然后将池中"abc"这个对象的引用地址
     * 返回给"abc"对象的引用s1，这样s1会指向字符串常量池中"abc"这个字符串对象；如果存在，
     * 则不创建任何对象，直接将池中"abc"这个对象的地址返回，赋给引用s2。
     * 因为s1、s2都是指向同一个字符串池中的"abc"对象，所以结果为true
     */
    @Test
    public void test1(){
        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
    }

    /**
     * 两个使用new关键字创建的字符串比较
     * 用new关键字新建一个字符串对象时，JVM首先在字符串池中查找有没有"xyz"这个字符串对象，
     * 如果有，则不在池中再去创建"xyz"这个对象了，直接在堆中创建一个"xyz"字符串对象，
     * 然后将堆中的这个"xyz"对象的地址返回赋给引用s3，这样，s3就指向了堆中创建的这个"xyz"字符串对象；
     * 如果没有，则首先在字符串池中创建一个"xyz"字符串对象，然后再在堆中创建一个"xyz"字符串对象，
     * 然后将堆中这个"xyz"字符串对象的地址返回赋给s3引用，这样，s3指向了堆中创建的这个"xyz"字符串对象。
     * s4则指向了堆中创建的另一个"xyz"字符串对象。s3 、s4是两个指向不同对象的引用，结果当然是false
     */
    @Test
    public void test2(){
        String s1 = new String("xyz");
        String s2 = new String("xyz");
        System.out.println(s1 == s2);
    }

    @Test
    public void test3(){
        String s1 = "xyz";
        String s2 = new String("xyz");
        System.out.println(s1 == s2);
    }

    /**
     *  s.intern()方法：
     *    在JDK1.6的时候，调用了这个方法之后，虚拟机会在字符串常量池在查找是否有内容与”tt”相等的对象，
     *    如果有，则返回这个对象，如果没有，则会在字符串常量池中添加这个对象。注意，
     *    是把这个对象添加到字符串常量池。
     *
     *    到了JDK1.7之后，如果调用了intern这个方法，
     *    虚拟机会在字符串常量池在查找是否有内容与”tt”相等的对象，如果有，则返回这个对象，如果没有。
     *    则会在堆中把这个对象的引用复制添加到字符串常量池中。注意，这个时候添加的是对象在堆中的引用。
     */
    @Test
    public void test11(){
        String s1 = new String("1") + new String("23");
        s1.intern();//执行此句后常量的引用指向堆中的引用
        String s2 = "123";//s2指向常量池中的引用，但是经过s1.intern()后常量池的引用其实就是堆中引用的拷贝
        System.out.println(s1 == s2);
    }

    @Test
    public void test12(){
        String s1 = new String("1") + new String("23");//此时s1指向堆中的引用
        String s2 = "123";//此时s2指向常量池中的引用
        s1.intern();
        System.out.println(s1 == s2);
    }
}
