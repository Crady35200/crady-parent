package com.crady.io.aio.client;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.CountDownLatch;

/**
 * author:Crady
 * date:2019/10/20 15:31
 * desc:
 **/
public class AioClientHandler implements Runnable, CompletionHandler<Void,AioClientHandler> {

    private String ip;
    private int port;
    private CountDownLatch latch;
    private AsynchronousSocketChannel channel;

    public AioClientHandler(String ip, int port) {
        this.ip = ip;
        this.port = port;
        try {
            channel = AsynchronousSocketChannel.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            latch = new CountDownLatch(1);
            channel.connect(new InetSocketAddress(ip,port),this,this);
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void completed(Void result, AioClientHandler attachment) {
        byte[] bytes = "query time order".getBytes();
        ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
        buffer.put(bytes);
        buffer.flip();
        channel.write(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                if(attachment.hasRemaining()){
                    channel.write(attachment,attachment,this);
                }else{
                    ByteBuffer b = ByteBuffer.allocate(1024);
                    channel.read(b, b, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            byte [] bs = new byte[attachment.remaining()];
                            attachment.get(bs);
                            try {
                                String re = new String(bs,"UTF-8");
                                System.out.println("aio client received : " + re);
                                latch.countDown();
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            exc.printStackTrace();
                            latch.countDown();
                        }
                    });
                }
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {
                exc.printStackTrace();
                latch.countDown();
            }
        });
    }

    @Override
    public void failed(Throwable exc, AioClientHandler attachment) {
        exc.printStackTrace();
        latch.countDown();
    }
}
