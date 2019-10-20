package com.crady.io.nio.client;

/**
 * author:Crady
 * date:2019/10/18 23:08
 * desc:
 **/
public class NioTimeClient {

    public static void main(String[] args) {
        new Thread(new NioTimeClientHandler()).start();
    }
}
