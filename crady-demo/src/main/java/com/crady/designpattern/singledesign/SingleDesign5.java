package com.crady.designpattern.singledesign;

/**
 * author:Crady
 * date:2019/1/4 15:13
 * desc: 懒汉模式-synchronized代码块同步(不可用)
 * 优点：在类首次使用时初始化，实现了lazy loading
 * 缺点：使用synchronized实现了同步，但是多个线程同时访问if(single == null)时会产生多个实例,且性能低下
 **/
public class SingleDesign5 {

    private static SingleDesign5 single = null;

    private SingleDesign5() {
    }

    public static SingleDesign5 getSingleDesign1() {
        if (single == null) {
            synchronized (SingleDesign5.class) {
                single = new SingleDesign5();
            }
        }
        return single;
    }
}
