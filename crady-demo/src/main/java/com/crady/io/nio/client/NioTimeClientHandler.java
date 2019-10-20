package com.crady.io.nio.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * author:Crady
 * date:2019/10/18 23:08
 * desc:
 **/
public class NioTimeClientHandler implements Runnable {

    private static final String IP = "localhost";
    private static final int PORT = 8000;
    private SocketChannel socketChannel;
    private Selector selector;
    private volatile boolean stop;


    public NioTimeClientHandler() {
        try {
            socketChannel = SocketChannel.open();
            socketChannel.configureBlocking(false);
            selector = Selector.open();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            doConnect();
            while (!stop) {
                selector.select(1000);
                Set<SelectionKey> keys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = keys.iterator();
                while(iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();
                    handlerInput(key);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void handlerInput(SelectionKey key) {
        try {
            if (key.isValid()) {
                SocketChannel channel = (SocketChannel) key.channel();
                if (key.isConnectable()) {
                    if(channel.finishConnect()){
                        System.out.println("nio client connect success");
                        channel.register(selector, SelectionKey.OP_READ);
                        doWrite(channel);
                    }else{
                        System.out.println("nio client connect failed");
                        System.exit(1);
                    }
                }
                if(key.isReadable()){
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    int read = channel.read(buffer);
                    if(read > 0){
                        buffer.flip();
                        byte [] bytes = new byte[buffer.remaining()];
                        buffer.get(bytes);
                        String result = new String(bytes,"UTF-8");
                        System.out.println("nio client receive: " + result);
                    }else if(read < 0){
                        if(key != null){
                            key.cancel();
                        }
                        if(channel != null){
                            channel.close();
                        }
                    }else{

                    }
                }
                if(key.isWritable()){

                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void doConnect() {
        try {
            if(socketChannel.connect(new InetSocketAddress(IP,PORT))){
                System.out.println("nio client connect success");
                socketChannel.register(selector, SelectionKey.OP_READ);
                doWrite(socketChannel);
            }else{
                socketChannel.register(selector, SelectionKey.OP_CONNECT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void doWrite(SocketChannel socketChannel) {
        try {
            byte[] bytes = "query time order".getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(bytes.length);
            buffer.put(bytes);
            buffer.flip();
            socketChannel.write(buffer);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void stop(){
        this.stop = true;
    }
}
