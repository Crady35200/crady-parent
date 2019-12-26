package com.crady.io.netty.server;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

import static io.netty.util.CharsetUtil.UTF_8;

/**
 * author:Crady
 * date:2019/08/18 20:46
 * desc:
 **/
@ChannelHandler.Sharable
@Slf4j
public class ServerHandler extends ChannelInboundHandlerAdapter {

    private int count;
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
 /*     有粘包/拆包问题
        ByteBuf byteBuf = (ByteBuf) msg;
        String result = byteBuf.toString(CharsetUtil.UTF_8);*/
        String result = (String)msg;
        log.info("msg={},count={}",result,++count);
        String s = "query now time".equals(result) ?
                "now time is : " + LocalDateTime.now() : "bad request";
        ctx.write(Unpooled.copiedBuffer(s + System.getProperty("line.separator"), UTF_8));
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
