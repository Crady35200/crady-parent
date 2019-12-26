package com.crady.io.netty.client;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * author:Crady
 * date:2019/08/18 20:25
 * desc:
 **/
@Slf4j
public class ClientHandler extends ChannelInboundHandlerAdapter {
    /**
     * 当客户端和服务端TCP链路建立成功后调用该方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("===============channelActive==================");
        ctx.writeAndFlush(Unpooled.copiedBuffer("Hello,Netty...", UTF_8));
    }

    /**
     * 当服务端返回应答消息是调用该方法
     * @param ctx
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.info("===============channelRead==================");
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("byteBuf = {}" , byteBuf.toString(UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        log.info("===============channelReadComplete==================");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
