package com.wyl.raw.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wangyunlong on 17/4/1.
 */
public class TestSocketServer {

    private static int port = 30000;

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))
        ) {
            System.out.println(clientSocket.getPort());
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("〖Server〗: " + inputLine);
                out.println("server- " + inputLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
