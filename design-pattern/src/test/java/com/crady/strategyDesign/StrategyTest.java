package com.crady.strategyDesign;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author :Crady
 * date :2019/7/17 18:00
 * desc :策略模式一般有三个角色，策略抽象角色（IStrategy），策略具体实现角色(StrategyA,StrategyB)，封装角色就是提供对外访问的接口(Context)
 * 经典应用：jdk中的ThreadPoolExecutor中的四种拒绝策略就是，策略模式的经典应用
 * 在Java的集合框架中，经常需要通过构造方法传入一个比较器Comparator，或者创建比较器传入Collections的静态方法中作为方法参数，进行比较排序等，
 * 使用的是策略模式。在该比较架构中，Comparator就是一个抽象的策略；一个类实现该结构，并实现里面的compare方法，该类成为具体策略类；
 * Collections类就是环境角色，他将集合的比较封装成静态方法对外提供api。
 **/
public class StrategyTest {

    @Test
    public void strategyTest(){
        IStrategy strategy = new StrategyA();
        Context context = new Context(strategy);
        context.doSomething();
        System.out.println("******************************************************");
        strategy = new StrategyB();
        context = new Context(strategy);
        context.doSomething();
    }

}