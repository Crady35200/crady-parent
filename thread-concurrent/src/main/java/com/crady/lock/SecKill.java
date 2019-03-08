package com.crady.lock;

/**
 * author:Crady
 * date:2019/1/4 17:17
 * desc:
 **/
public class SecKill {

    int n = 10;
    int count = 10000;

    public void commonKill(){
        for (int i = 0; i < count; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                   n-=1;
                }
            }).start();
        }
    }

}
