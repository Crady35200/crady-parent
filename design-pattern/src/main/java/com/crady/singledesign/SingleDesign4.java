package com.crady.singledesign;

/**
 * author:Crady
 * date:2019/1/4 15:13
 * desc: 懒汉模式-synchronized方法同步(不推荐使用)
 * 优点：在类首次使用时初始化，实现了lazy loading
 * 缺点：使用synchronized实现了同步，但是性能低下
 **/
public class SingleDesign4 {

    private static SingleDesign4 single = null;

    private SingleDesign4() {
    }

    public static synchronized SingleDesign4 getSingleDesign1(){
        if(single == null){
            single  = new SingleDesign4();
        }
        return single;
    }
}
