package com.wyl.raw.url;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wangyunlong on 17/4/5.
 */
public class HttpPostClient {

    private static String URL = "https://yun.tim.qq.com/v5/tlssmssvr/sendisms";
    private static String POST = "POST";
    private static String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) {
        Map<String, String> postBody = new HashMap<>();
        postBody.put("test1", "1");
        postBody.put("test2", "2");
        postBody.put("test3", "3");
        try {
            URL url = new URL(URL);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setRequestMethod(POST);
            conn.setDoOutput(true);
            conn.setRequestProperty("User-Agent", USER_AGENT);
            conn.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
            writer.write(postBody.toString());
            writer.flush();
            writer.close();

            System.out.println("code" + conn.getResponseCode());
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
