package com.crady.io.aio.server;

/**
 * author:Crady
 * date:2019/10/20 14:17
 * desc: Aio服务端
 **/
public class AioTimeServer {
    private static final int PORT = 9000;;

    public static void main(String[] args) {
        new Thread(new AioTimeServerHandler(PORT)).start();
    }
}
