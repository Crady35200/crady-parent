package com.crady.io.aio.server;

import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

/**
 * author:Crady
 * date:2019/10/20 14:23
 * desc:
 **/
public class AcceptCompletionHandler implements CompletionHandler<AsynchronousSocketChannel, AioTimeServerHandler> {

    @Override
    public void completed(AsynchronousSocketChannel result, AioTimeServerHandler attachment) {
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        result.read(buffer,buffer,new ReadCompletionHandler(result));
    }

    @Override
    public void failed(Throwable exc, AioTimeServerHandler attachment) {
        exc.printStackTrace();
        attachment.latch.countDown();
    }
}
