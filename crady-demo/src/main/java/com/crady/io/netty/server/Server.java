package com.crady.io.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * author:Crady
 * date:2019/08/18 20:45
 * desc:
 **/
public class Server {

    private static final int PORT = 9999;

    private ServerHandler handler = new ServerHandler();

    public static void main(String[] args) {
        new Server().start();
    }

    private void start() {
        EventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
                //指定所使用的NIO传输Channel
                .channel(NioServerSocketChannel.class)
                //使用指定的端口
                .localAddress(PORT)
                //添加一个ServerHandler到子Channel的ChannelPipeline
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        //不添加以下两个解码器会有粘包/拆包问题
                        socketChannel.pipeline().addLast(new LineBasedFrameDecoder(1024));
                        socketChannel.pipeline().addLast(new StringDecoder());
                        //ServerHandler上面有Sharable注解表明是线程安全的
                        socketChannel.pipeline().addLast(handler);
                    }
                });
        try {
            //异步地绑定服务器调用sync方法阻塞等待直到绑定完成
            ChannelFuture future = bootstrap.bind().sync();
            //获取Channel的CloseFuture并且阻塞当前线程直到完成
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            //优化的关闭EventLoopGroup并释放所有的资源
            group.shutdownGracefully();
            e.printStackTrace();
        }
    }
}
