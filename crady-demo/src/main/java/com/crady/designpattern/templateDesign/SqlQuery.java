package com.crady.designpattern.templateDesign;

/**
 * @author :Crady
 * date :2019/7/18 14:20
 * desc :
 **/
public class SqlQuery extends SqlEngine {

    @Override
    protected void connect() {
        System.out.println("普通查询---连接数据库");
    }

    @Override
    protected void beginTrasaction() {
        System.out.println("普通查询---开启事务");
    }

    @Override
    protected void subPage() {
        System.out.println("普通查询---分页");
    }

    @Override
    protected void commit() {
        System.out.println("普通查询---提交事务");
    }
}
