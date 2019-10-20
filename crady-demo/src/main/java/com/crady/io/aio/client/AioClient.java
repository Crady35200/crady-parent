package com.crady.io.aio.client;

/**
 * author:Crady
 * date:2019/10/20 15:30
 * desc: aio客户端
 **/
public class AioClient {

    private static final String IP = "localhost";
    private static final int PORT = 9000;

    public static void main(String[] args) {
        new Thread(new AioClientHandler(IP,PORT)).start();
    }
}
