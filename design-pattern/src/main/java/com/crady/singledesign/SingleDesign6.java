package com.crady.singledesign;

/**
 * author:Crady
 * date:2019/1/4 15:13
 * desc: 懒汉模式-synchronized代码块同步，双重检查(推荐使用)
 * 优点：lazy loading，线程安全，效率较高
 * 缺点：使用synchronized实现了同步
 **/
public class SingleDesign6 {

    private static volatile SingleDesign6 single = null;

    private SingleDesign6() {
    }

    public static SingleDesign6 getSingleDesign1(){
        if(single == null){
            synchronized(SingleDesign6.class){
                if(single == null){
                    single = new SingleDesign6();
                }
            }
        }
        return single;
    }
}
