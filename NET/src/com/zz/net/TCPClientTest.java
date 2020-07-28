package com.zz.net;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientTest {
    public static void main(String[] args) {
        Socket socket = null;
        OutputStream os = null;

        try {
            //服务器地址
            InetAddress serverIP = InetAddress.getByName("127.0.0.1");
            //端口号
            int port = 9999;
            //创建socket连接
            socket = new Socket(serverIP,port);
            //发送消息 IO 流
            os = socket.getOutputStream();
            os.write("hello".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (os != null){
                try {
                    os.close();
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

        }
    }
}
