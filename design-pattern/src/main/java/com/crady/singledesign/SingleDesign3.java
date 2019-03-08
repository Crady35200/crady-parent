package com.crady.singledesign;

/**
 * author:Crady
 * date:2019/1/4 15:13
 * desc: 懒汉模式(不可用)
 * 优点：在类首次使用时初始化，实现了lazy loading
 * 缺点：只能在单线程下使用，在多线程下同步访问if(single == null)会导致产生多个实例
 **/
public class SingleDesign3 {

    private static SingleDesign3 single = null;

    private SingleDesign3() {
    }

    public static SingleDesign3 getSingleDesign1(){
        if(single == null){
            single  = new SingleDesign3();
        }
        return single;
    }
}
