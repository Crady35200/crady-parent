package com.crady.io.netty.client;

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

    private int count;
    /**
     * 当客户端和服务端TCP链路建立成功后调用该方法
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        log.info("===============channelActive==================");
        for (int i = 0; i < 100; i++) {
            ctx.writeAndFlush(Unpooled.copiedBuffer("query now time" + System.getProperty("line.separator"), UTF_8));
        }
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
/*      有拆包/粘包问题
        ByteBuf byteBuf = (ByteBuf) msg;
        log.info("byteBuf = {},count={}" , byteBuf.toString(UTF_8),++count);*/
        String result = (String) msg;
        log.info("byteBuf = {},count={}" , result,++count);
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
