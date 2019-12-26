package com.crady.io.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

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
                .handler(new ChannelInitializer<Channel>() {
                    @Override
                    protected void initChannel(Channel channel) throws Exception {
                        //不添加以下两个解码器会有粘包/拆包问题
                        channel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                        channel.pipeline().addLast(new StringDecoder());

                        channel.pipeline().addLast(new ClientHandler());
                    }
                });
        try {
            ChannelFuture future = bootstrap.connect().sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            try {//优雅退出释放NIO线程组
                group.shutdownGracefully().sync();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
