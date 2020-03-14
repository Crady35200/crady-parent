package com.crady.thread.tools;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author :Crady
 * date :2020/03/14 22:00
 * desc : 用户线程间交换数据
 *    比如银行的对账工作：让职员A录入一遍数据，然后让职员B也录入同样的一份
 *    数据，然后比对A和B看是否有误差。
 **/
public class ExchangerDemo {

    Exchanger<Integer> exchanger = new Exchanger<>();

    ExecutorService pool = Executors.newFixedThreadPool(2);

    public void demo(){
        pool.submit(() -> {
            long id = Thread.currentThread().getId();
            System.out.println(id + "---" + 5);
            try {
                Integer exchange = exchanger.exchange(5);
                System.out.println(id + "---" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        pool.submit(() -> {
            long id = Thread.currentThread().getId();
            System.out.println(id + "---" + 8);
            try {
                //此处可以获取第一个线程中执行的值然后和本线程获取的值作比较验证
                Integer exchange = exchanger.exchange(8);
                if(8 == exchange){
                    System.out.println("两次统计输入一致");
                }else {
                    System.out.println("两次统计输入不一致");

                }
                System.out.println(id + "---" + exchange);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new ExchangerDemo().demo();
    }
}
