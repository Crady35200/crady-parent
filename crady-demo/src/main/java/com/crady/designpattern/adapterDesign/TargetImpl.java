package com.crady.designpattern.adapterDesign;

/**
 * @author :Crady
 * date :2019/7/17 14:34
 * desc :
 **/
public class TargetImpl implements Target{

    @Override
    public void doSomething() {
        System.out.println("target do something...");
    }
}
