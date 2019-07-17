package com.crady.adapterDesign;

import org.apache.tools.ant.taskdefs.Tar;

/**
 * @author :Crady
 * date :2019/7/17 14:39
 * desc :适配器模式一般有三个角色，目标类(一般是抽象类或者接口),源类，适配器类
 * 对象适配器，一般是实现目标类注入源类(推荐使用)
 **/
public class ObjectAdapter implements Target {
    private Adaptee adaptee;
    public ObjectAdapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void doSomething() {
        this.adaptee.doAnotherthing();
    }
}
