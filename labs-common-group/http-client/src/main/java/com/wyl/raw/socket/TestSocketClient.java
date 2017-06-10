package com.wyl.raw.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by wangyunlong on 17/4/1.
 *
 * 先启动TestSocketServer
 */
public class TestSocketClient {

    private static String hostname = "127.0.0.1";
    private static int port = 30000;

    public static void main(String[] args) {

        try (Socket socket = new Socket(hostname, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                out.println(userInput);
                System.out.println(in.readLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
