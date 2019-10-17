package com.crady.io.bio.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * author:Crady
 * date:2019/10/17 20:31
 * desc:
 **/
public class TimeServer {

    private static final int PORT = 8888;

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("serverSocket start on port: " + PORT);
            Socket socket = null;
            while(true){
                socket = serverSocket.accept();
                new TimeServerHandler(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket != null){
                try {
                    System.out.println("the timeServer is closed");
                    serverSocket.close();
                    serverSocket = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
