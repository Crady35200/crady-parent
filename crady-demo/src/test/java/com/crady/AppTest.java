package com.crady;

import org.junit.Test;

import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest {
    private Field field;

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void demo() {
        String key = "crady";
        int h;
        System.out.println(key.hashCode());
        System.out.println(key.hashCode() >>> 16);
        System.out.println(Integer.toBinaryString(key.hashCode()) + "===" + Integer.toBinaryString(key.hashCode() >>> 16));
        int a = (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(h);
        System.out.println(a);

    }

    @Test
    public void demo2() {
        int MAXIMUM_CAPACITY = 1 << 30;
        int n = 0 - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        int r = (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
        System.out.println(r);
    }

    @Test
    public void demo3(){

        User u = new User();
        u.setName("crady");
        u.setAge(30);
        System.out.println(u);
        User b = new User();
        b = u;
        b.setAge(20);
//        u = null;
        System.out.println(u);
        System.out.println(b);

    }

    @Test
    public void test4(){
        AtomicLong count = new AtomicLong();
        long start = System.currentTimeMillis();
        System.out.println(start);
        while(true){
            count.incrementAndGet();
            long end = System.currentTimeMillis();
            if(end - start > 1000){
                System.out.println(end);
                break;
            }
        }//88967750
        System.out.println(count);
    }

    @Test
    public void tDemo() {

        new Thread(() -> System.out.println("thread ...")).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread ...");
            }
        }).start();

    }

    @Test
    public void demo5() throws CloneNotSupportedException {
        String str = "hello world";
        String s1 = str.intern();
        String s2 = str;
        String s3 = "hello world";
        String s4 = new String("hello world");
        System.out.println(str == s1);
        System.out.println(str == s2);
        System.out.println(str == s3);
        System.out.println(str == s4);
        System.out.println(str.hashCode() + "," + s1.hashCode());
    }

    @Test
    public void demo6(){
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap<String,String>();
        concurrentHashMap.put("1","a");
    }
}
