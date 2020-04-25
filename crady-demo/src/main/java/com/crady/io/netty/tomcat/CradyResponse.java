package com.crady.io.netty.tomcat;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.*;

import static io.netty.handler.codec.http.HttpHeaderNames.*;

/**
 * @author :Crady
 * date :2020/04/25 20:21
 * desc :
 **/
public class CradyResponse {

    private ChannelHandlerContext ctx;
    private HttpRequest request;

    public CradyResponse(){

    }
    public CradyResponse(ChannelHandlerContext ctx, HttpRequest request){
        this.ctx = ctx;
        this.request = request;
    }

    public void write(String msg){
        try{
            FullHttpResponse response = new DefaultFullHttpResponse(
                    HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                    Unpooled.wrappedBuffer(msg.getBytes("UTF-8")));
            response.headers().set(CONTENT_TYPE,"text/json");
            response.headers().set(CONTENT_LENGTH,response.content().readableBytes());
            response.headers().set(EXPIRES,0);
            if(HttpHeaders.isKeepAlive(response)){
                response.headers().set(CONNECTION, HttpHeaders.Values.KEEP_ALIVE);
            }
            ctx.write(response);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ctx.flush();
        }
    }

}
