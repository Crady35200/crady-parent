package com.crady.delegateDesign;

import org.junit.Test;

/**
 * @author :Crady
 * date :2019/5/16 11:30
 * desc :主要角色有三种: 抽象任务角色, 委派者角色, 具体任务角色.
 * 优点: 对内隐藏实现, 易于扩展; 简化调用;
 **/
public class DelegateDesignTest {

    @Test
    public void delegateDesignTest(){
        Manager manager = new Manager();
        manager.execute("order");
        manager.execute("pay");
    }
}