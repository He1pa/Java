package com.zz.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTest {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;
        try {
            //需要地址
            serverSocket = new ServerSocket(9999);

            //等待客户端连接
            socket = serverSocket.accept();

            //读取客户端消息
            is = socket.getInputStream();
            
            //管道流
            bos = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1){
                bos.write(buffer,0,len);
            }

            System.out.println(bos.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
