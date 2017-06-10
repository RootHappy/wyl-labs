package com.wyl.raw.socket;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by wangyunlong on 17/4/1.
 */
public class TestDatagramServer {

    private static int port = 30001;

    public static void main(String[] args) {
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        try {
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Server started");
            while (true) {
                socket.receive(packet);
                System.out.println("port: " + packet.getPort());
                System.out.println("address: " + packet.getAddress());
                System.out.printf("" + new String(packet.getData(), 0, packet.getLength()));

                socket.send(packet);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
