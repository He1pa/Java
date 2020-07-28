package com.zz.net;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

//不需要连接服务器
public class UDPClientTest01 {
    public static void main(String[] args) throws Exception {
        //建立一个Socket
        DatagramSocket socket = new DatagramSocket();
        //建包
        String msg = "Hello";

        //发送的目标
        InetAddress localhost = InetAddress.getByName("localhost");
        int port = 9000;
        DatagramPacket packet = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localhost, port);
        //发送包
        socket.send(packet);

        //关闭流
        socket.close();
    }

}
