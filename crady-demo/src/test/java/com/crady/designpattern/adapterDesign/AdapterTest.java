package com.crady.designpattern.adapterDesign;

import org.junit.Test;

/**
 * @author :Crady
 * date :2019/7/17 14:42
 * desc :适配器模式主要是把一个想用的接口但是又不匹配现有接口的接口转化为能使用的接口。
 * 主要有三个角色：目标接口(Target)、适配器类、源类-被适配者(Adaptee)
 * 形态：主要有对象适配器和类适配器，一般使用对象适配器，因为更加灵活。
 **/
public class AdapterTest {

    @Test
    public void classAdapterTest(){
        Target target = new ClassAdapter();
        target.doSomething();
    }

    @Test
    public void objectAdapterTest(){
        Target target = new ObjectAdapter(new Adaptee());
        target.doSomething();
    }

}