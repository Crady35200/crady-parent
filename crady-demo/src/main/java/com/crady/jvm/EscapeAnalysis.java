package com.crady.jvm;


/**
 * @author :Crady
 * date :2019/7/19 9:18
 * desc :
 * -server -XX:+PrintGC -XX:+DoEscapeAnalysis -XX:+EliminateAllocations
 * jdk1.8  DoEscapeAnalysis和EliminateAllocations都是开启的
 * 默认或者开启，该段程序Admin对象的大部分会栈上分配，好说在4ms左右在不会发生GC
 * 如果配置-XX:-DoEscapeAnalysis 或者-XX:-EliminateAllocations所有对象会在堆上分配，大约会发生12左右GC耗时大概700ms左右
 * 提示：可以通过线程睡眠使程序保存存活来查看内存中Admin对象的数量,JPS获取县城ID，然后使用 jmap -histo pid来查看
 **/
public class EscapeAnalysis {

    public static void testEscape(){
       Admin admin = new Admin();
       admin.setId(1);
       admin.setName("crady");
    }

    static class Admin{
        public int id;
        public String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            testEscape();
        }
        System.out.println((System.currentTimeMillis() - start) + "ms");
/*        try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}
