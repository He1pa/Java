package com.zz.net;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClientTest02 {
    public static void main(String[] args) throws Exception {
        //创建socket连接
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9000);

        //创建输出流
        OutputStream os = socket.getOutputStream();
        //读取文件
        FileInputStream fis = new FileInputStream(new File("NET.iml"));

        //写出文件
        byte[] buffer = new byte[1024];
        int len;
        while ((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }
        //通知服务器传输完毕
        socket.shutdownOutput();
        //确定服务器接收完毕
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer2 = new byte[1024];
        int len2;
        while((len2 = inputStream.read(buffer2)) != -1){
            baos.write(buffer2,0,len2);
        }
        System.out.println(baos.toString());
        //关闭资源
        baos.close();
        inputStream.close();
        fis.close();
        os.close();
        socket.close();
    }

}
