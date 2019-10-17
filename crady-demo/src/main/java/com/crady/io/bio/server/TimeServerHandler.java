package com.crady.io.bio.server;

import java.io.*;
import java.net.Socket;
import java.util.Date;

/**
 * author:Crady
 * date:2019/10/17 20:41
 * desc:
 **/
public class TimeServerHandler extends Thread {
    private Socket socket;
    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        String line;
        try {
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()),true);
            String result;
            while (true){
                if ((line = reader.readLine()) != null){
                    System.out.println("server received: " + line);
                    result = "query time order".equals(line) ?
                            new Date(System.currentTimeMillis()).toString()
                            : "Bad ORDER";
                    writer.println(result);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            try {
                if(reader != null){
                    reader.close();
                }
                if(writer != null){
                    writer.close();
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
