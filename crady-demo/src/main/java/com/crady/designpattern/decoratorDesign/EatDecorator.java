package com.crady.designpattern.decoratorDesign;

/**
 * @author :Crady
 * date :2019/7/17 17:00
 * desc :
 **/
public class EatDecorator extends Decorator{

    public EatDecorator(ISource iSource) {
        super(iSource);
    }

    @Override
    public void hello() {
        super.hello();
        System.out.println("Do you have breakfest ?");
    }
}
