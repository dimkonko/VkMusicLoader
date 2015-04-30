package net.dimkonko.vkmlj.etc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by Dima Karacheban on 29.04.2015.
 */
public class VkAPI {
    private static final String API_URL = "https://api.vk.com/method/";

    protected String call(String method, List<String> args) {
        String url = UrlBuilder.create(API_URL.concat(method), args);
        return sendReq(url);
    }

    private String sendReq(String urlStr) {
        String response = null;
        try {
            URL url = new URL(urlStr);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            int respCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer strBuffer = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                strBuffer.append(inputLine);
            }
            in.close();
            response = strBuffer.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
