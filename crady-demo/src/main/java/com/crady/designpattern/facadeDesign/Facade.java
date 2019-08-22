package com.crady.designpattern.facadeDesign;

/**
 * @author :Crady
 * date :2019/7/18 11:35
 * desc :
 **/
public class Facade {

    private FunctionA functionA = new FunctionA();
    private FunctionB functionB = new FunctionB();
    private FunctionC functionC = new FunctionC();

    public void doSomethingA(){
        functionA.doSomething();
    }
    public void doSomethingB(){
        functionB.doSomething();
    }
    public void doSomethingC(){
        functionC.doSomething();
    }

}
