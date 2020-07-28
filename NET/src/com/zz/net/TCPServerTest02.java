package com.zz.net;

import sun.awt.windows.WBufferStrategy;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerTest02 {
    public static void main(String[] args) throws Exception {
        //创建服务
        ServerSocket serverSocket = new ServerSocket(9000);
        //监听客户端连接
        Socket socket = serverSocket.accept();
        //获取输入流
        InputStream is = socket.getInputStream();

        //文件输出
        FileOutputStream fos = new FileOutputStream(new File("receive.iml"));
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        //告知客户端接收完毕
        OutputStream os = socket.getOutputStream();
        os.write("接收完毕".getBytes());
        //关闭资源
        fos.close();
        is.close();
        socket.close();
        serverSocket.close();

    }
}
