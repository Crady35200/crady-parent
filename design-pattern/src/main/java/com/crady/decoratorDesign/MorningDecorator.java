package com.crady.decoratorDesign;

/**
 * @author :Crady
 * date :2019/7/17 16:56
 * desc :
 **/
public class MorningDecorator extends Decorator {

    public MorningDecorator(ISource iSource) {
        super(iSource);
    }

    @Override
    public void hello() {
        System.out.println("Good Morning");
        super.hello();
    }
}
