package com.crady.io.nio.server;

/**
 * author:Crady
 * date:2019/10/18 21:49
 * desc: nio服务端
 **/
public class NioTimeServer {
    public static void main(String[] args) {
        new Thread(new NioTimeServerHandler()).start();
    }
}
