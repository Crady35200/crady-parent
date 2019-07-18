package com.crady.templateDesign;

/**
 * @author :Crady
 * date :2019/7/18 14:20
 * desc :
 **/
public class SqlSubPageQuery extends SqlEngine {

    private boolean isSubPage;

    @Override
    protected void connect() {
        System.out.println("分页查询---连接数据库");
    }

    @Override
    protected void beginTrasaction() {
        System.out.println("分页查询---开启事务");
    }

    @Override
    protected void subPage() {
        System.out.println("分页查询---分页");
    }

    @Override
    protected void commit() {
        System.out.println("分页查询---提交事务");
    }

    @Override
    protected boolean isSubPage() {
        return this.isSubPage;
    }
    public void setSubPage(boolean isSubPage){
        this.isSubPage = isSubPage;
    }
}
