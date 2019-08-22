package com.crady.designpattern.templateDesign;

/**
 * @author :Crady
 * date :2019/7/18 14:16
 * desc :
 **/
public abstract class SqlEngine {

    protected abstract void connect();
    protected abstract void beginTrasaction();
    protected abstract void subPage();
    protected boolean isSubPage(){
        return false;
    }
    protected void execute(){
        this.connect();
        this.beginTrasaction();
        if(isSubPage()){
            this.subPage();
        }
        this.commit();
    }
    protected abstract void commit();


}
