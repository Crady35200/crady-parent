package com.crady.io.bio.client;

import java.io.*;
import java.net.Socket;

/**
 * author:Crady
 * date:2019/10/17 21:13
 * desc:
 **/
public class TimeClient {
    private static final String IP = "localhost";
    private static final int PORT = 8888;

    public static void main(String[] args) {
        Socket socket = null;
        BufferedWriter writer = null;
        PrintWriter out = null;
        try {
            socket = new Socket(IP,PORT);
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            out.println("query time order");
            System.out.println("send success");
            TimeClientHandler handler = new TimeClientHandler(socket);
            handler.start();
            handler.join();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                if(writer != null){
                    writer.close();
                }
                if(out != null){
                    out.close();
                }
                if(socket != null){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
