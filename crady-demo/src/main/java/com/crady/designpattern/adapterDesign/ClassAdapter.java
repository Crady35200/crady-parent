package com.crady.designpattern.adapterDesign;

/**
 * @author :Crady
 * date :2019/7/17 14:38
 * desc :  类适配器模式，一般是继承源类，实现目标类
 **/
public class ClassAdapter extends Adaptee implements Target{

    @Override
    public void doSomething() {
        super.doAnotherthing();
    }
}
