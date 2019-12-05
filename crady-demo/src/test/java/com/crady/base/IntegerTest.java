package com.crady.base;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author :Crady
 * date :2019/12/5 15:38
 * desc :
 **/
public class IntegerTest {

    private static long VAL_OFFSET;
    private static Unsafe unsafe;

    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
            VAL_OFFSET = unsafe.objectFieldOffset(Integer.class.getDeclaredField("value"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void iTest(){
        Integer a = 1000,b=5000;
//        swap(a,b);
//        unSafeSwap(a,b);
        errorSwap(a,b);
        System.out.println("a = " + a + ",b= " + b);
    }

    /**
     * 通过反射实现整数交换
     * @param a
     * @param b
     */
    public void swap(Integer a,Integer b){
        System.out.println("通过反射实现整数交换");
        try {
            Field field = Integer.class.getDeclaredField("value");
            field.setAccessible(true);
            int tmp = a;
            field.set(a,b);
            /**
             * 此处要new的原因是，int自动装箱拆箱如果值在-128~127之间，则
             * 获取的还是原值(可以参考Integer.valueOf源码)，如果比较的int值
             * 不在-128~127则是没有问题。
             */
            field.set(a,new Integer(tmp));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过Unsafe实现整数交换
     * @param a
     * @param b
     */
    public void unSafeSwap(Integer a,Integer b){
        System.out.println("通过Unsafe实现整数交换");
        int tmp = a;
        unsafe.putInt(a,VAL_OFFSET,b);
        unsafe.putInt(b,VAL_OFFSET,tmp);
    }


    /**
     * 错误的交换方式示例,Integer的value属性是final类型的
     * 所有不能通过普通3步交换方式实现交换
     * @param a
     * @param b
     */
    public void errorSwap(Integer a ,Integer b){
        System.out.println("错误的交换方式示例");
        int tmp = a;
        a = b;
        b = tmp;
    }

}
