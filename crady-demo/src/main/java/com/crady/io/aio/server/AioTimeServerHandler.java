package com.crady.io.aio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.concurrent.CountDownLatch;

/**
 * author:Crady
 * date:2019/10/20 14:18
 * desc:
 **/
public class AioTimeServerHandler implements Runnable {

    private int port;
    private AsynchronousServerSocketChannel serverSocketChannel;
    CountDownLatch latch;

    public AioTimeServerHandler(int port) {
        this.port = port;
        try {
            serverSocketChannel = AsynchronousServerSocketChannel.open();
            serverSocketChannel.bind(new InetSocketAddress(this.port));
            System.out.println("aio server is start on port : " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        latch = new CountDownLatch(1);
        doAccept();
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void doAccept() {
        serverSocketChannel.accept(this,new AcceptCompletionHandler());
    }
}
