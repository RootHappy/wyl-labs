package com.wyl.raw.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by wangyunlong on 17/4/1.
 */
public class TestDatagramClient {

    public static void main(String[] args) {
        byte[] buf = new byte[1024];
        DatagramPacket inPacket = new DatagramPacket(buf, buf.length);
        DatagramPacket outPacket;
        try (BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            DatagramSocket socket = new DatagramSocket();
            InetAddress hostAddress = InetAddress.getByName("localhost");
            while (true) {
                String inputLine = stdIn.readLine();
                if ("bye".equals(inputLine)) {
                    break;
                }
                byte[] bytes = inputLine.getBytes();
                outPacket = new DatagramPacket(bytes, bytes.length, hostAddress, 30001);
                socket.send(outPacket);

                socket.receive(inPacket);
                System.out.println(inPacket.getAddress());
                System.out.println(inPacket.getPort());
                System.out.println(new String(inPacket.getData(), 0, inPacket.getLength()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
