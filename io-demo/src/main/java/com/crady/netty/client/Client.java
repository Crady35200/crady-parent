package com.crady.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.net.InetSocketAddress;

/**
 * author:Crady
 * date:2019/08/18 20:11
 * desc:
 **/
public class Client {

    private static final String HOST = "127.0.0.1";
    private static final int PORT = 9999;

    public static void main(String[] args) {
        new Client().start();
    }

    private void start() {
        //线程组
        EventLoopGroup group = new NioEventLoopGroup();
        //客户端启动
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                //指明Nio通讯
                .channel(NioSocketChannel.class)
                //配置远程网络地址
                .remoteAddress(new InetSocketAddress(HOST,PORT))
                .handler(new ClientHandler());
        try {
            bootstrap.connect().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }/*finally {
            try {
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }*/

    }
}
