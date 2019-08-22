package com.crady.designpattern.templateDesign;

import org.junit.Test;

/**
 * @author :Crady
 * date :2019/7/18 14:24
 * desc :模版模式主要用户有固定的工作流程，如果有公共的方法可以放到抽象类中，差异的方法放到实现类中实现
 * 主要有两个角色：抽象模版类，实现类(可以用多个)
 * 优点：1、封装不变的，扩展可以变的。
 *       2、提取公共代码便于维护。
 *       3、行为由父类控制，子类实现。
 * 缺点：子类的执行结果影响了父类的执行结果，增加了代码阅读难度
 * 经典应用：jdk中的ReentrantLock等自定义锁
 *           mybaits中的Executor模块
 **/
public class TemplateDesignTest {

    @Test
    public void templateDesignTest(){
        SqlEngine sqlEngine = new SqlQuery();
        sqlEngine.execute();
        System.out.println("******************************************************");
        SqlSubPageQuery se = new SqlSubPageQuery();
        se.setSubPage(true);
        se.execute();

    }
}