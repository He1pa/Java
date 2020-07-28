package com.zz.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPReceiveDemo01 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);

        while (true){
            //准备接受packet
            byte[] container = new byte[1024];
            DatagramPacket packet = new DatagramPacket(container,0,container.length);
            socket.receive(packet);//阻塞式接受包裹
            //断开连接
            byte[] data = packet.getData();
            String receiveData = new String(data, 0, data.length);
            System.out.println(receiveData);
            if (receiveData.equals("bye")){
                break;

            }

        }

        socket.close();
    }
}
