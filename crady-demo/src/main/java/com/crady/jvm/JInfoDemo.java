package com.crady.jvm;

/**
 * @author :Crady
 * date :2019/7/19 17:17
 * desc :
 * VM Args:-Xms5m -Xmx5m -Xmn2m -XX:+PrintGC
 * 动态修改虚拟机参数 jinfo -flag +PrintGCDetails 19512
 **/
public class JInfoDemo {

    public static void main(String[] args) throws InterruptedException {
        while (true){
            byte [] b = null;
            for (int i = 0; i < 10; i++) {
                b = new byte[1024 * 1024];
            }
            Thread.sleep(5000);
        }
    }
}
