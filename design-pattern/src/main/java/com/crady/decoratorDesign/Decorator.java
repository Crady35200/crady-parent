package com.crady.decoratorDesign;

/**
 * @author :Crady
 * date :2019/7/17 16:54
 * desc :
 **/
public abstract class Decorator implements ISource {

    private ISource iSource;

    public Decorator(ISource iSource) {
        this.iSource = iSource;
    }

    @Override
    public void hello() {
        this.iSource.hello();
    }
}
