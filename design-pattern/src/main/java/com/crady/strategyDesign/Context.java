package com.crady.strategyDesign;

/**
 * @author :Crady
 * date :2019/7/17 17:58
 * desc :策略模式一般有三个角色，策略抽象角色（IStrategy），策略具体实现角色(StrategyA,StrategyB)，封装角色就是提供对外访问的接口(Context)
 **/
public class Context {
    private IStrategy strategy;

    public Context(IStrategy strategy) {
        this.strategy = strategy;
    }
    public void doSomething(){
        strategy.doSomething();
    }
}
