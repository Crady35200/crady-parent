package com.crady.io.nio.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

/**
 * author:Crady
 * date:2019/10/18 21:50
 * desc:
 **/
public class NioTimeServerHandler implements Runnable {

    private static final int PORT = 8000;
    private ServerSocketChannel server;
    private Selector selector;
    private volatile boolean stop;

    public NioTimeServerHandler() {
        try {
            server = ServerSocketChannel.open();
            server.socket().bind(new InetSocketAddress(PORT),1024);
            server.configureBlocking(false);
            selector = Selector.open();
            server.register(selector, SelectionKey.OP_ACCEPT);
            System.out.println("nio sever start on port: " + PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while(!stop){
            try {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                SelectionKey key;
                while (iterator.hasNext()){
                    key = iterator.next();
                    iterator.remove();
                    handlerInput(key);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void handlerInput(SelectionKey key) {
        if(key.isValid()){
            try{
                if(key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    channel.configureBlocking(false);
                    channel.register(selector,SelectionKey.OP_READ);
                }
                if(key.isReadable()){
                    SocketChannel channel = (SocketChannel) key.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int read = channel.read(buffer);
                    String result;
                    if(read > 0){
                        buffer.flip();
                        byte [] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        System.out.println("buffer.remain=" + bytes.length + ",read=" + read);
                        result = new String(bytes);
                        System.out.println("the nio server received: " + result);
                        String currentTime = "query time order".equals(result) ?
                                new Date(System.currentTimeMillis()).toString()
                                : "BAD ORDER";
                        doWrite(channel,currentTime);
                    }else if(read < 0){
                        if(channel != null){
                            channel.close();
                        }
                        if(key != null){
                            key.cancel();
                        }
                    }else{

                    }
                }
                if(key.isWritable()){

                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void doWrite(SocketChannel channel, String currentTime) {
        try {
            if(currentTime == null || currentTime.length() < 1){
                return;
            }
            byte[] bytes = currentTime.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            buffer.put(bytes);
            buffer.flip();
            channel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stop(){
        this.stop = true;
    }
}
