package com.wyl.raw.url;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by wangyunlong on 17/4/5.
 */
public class HttpGetClient {

    private static String URL = "http://www.google.com/search?q=wang";
    private static String GET_REQUEST_METHOD = "GET";
    private static String USER_AGENT = "Mozilla/5.0";


    public static void main(String[] args) {
        try {
            URL url = new URL(URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoInput(true);
            conn.setRequestMethod(GET_REQUEST_METHOD);
            conn.setRequestProperty("User-Agent", USER_AGENT);

            int responseCode = conn.getResponseCode();
            System.out.printf("Url： " + url + "; code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer buffer = new StringBuffer();
            while ((inputLine = reader.readLine()) != null) {
                buffer.append(inputLine);
            }
            reader.close();
            System.out.println(buffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
