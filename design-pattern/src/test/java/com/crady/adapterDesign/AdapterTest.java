package com.crady.adapterDesign;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author :Crady
 * date :2019/7/17 14:42
 * desc :
 **/
public class AdapterTest {

    @Test
    public void classAdapterTest(){
//        Target target = new TargetImpl();
        Target target = new ClassAdapter();
        target.doSomething();
    }

    @Test
    public void objectAdapterTest(){
//        Target target = new TargetImpl();
        Target target = new ObjectAdapter(new Adaptee());
        target.doSomething();
    }

}