package com.crady.io.bio.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * author:Crady
 * date:2019/10/17 21:26
 * desc:
 **/
public class TimeClientHandler extends Thread{
    private Socket socket;

    public TimeClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        receive();
    }

    public void receive(){
        BufferedReader reader = null;
        try{
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            while((line = reader.readLine()) != null){
                System.out.println("receive from server : " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(reader != null){
                    reader.close();
                }
                if(socket != null){
                    socket.close();
                    socket = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
