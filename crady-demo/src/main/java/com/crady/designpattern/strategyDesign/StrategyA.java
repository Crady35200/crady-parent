package com.crady.designpattern.strategyDesign;

/**
 * @author :Crady
 * date :2019/7/17 17:58
 * desc :
 **/
public class StrategyA implements IStrategy {

    @Override
    public void doSomething() {
        System.out.println("StrategyA do something");
    }
}
