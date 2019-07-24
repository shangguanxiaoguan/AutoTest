package com.sangame.hjm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 发送HTTP请求——GET请求
 */

public class HttpMethodGetUtil {

//    public static void main(String[] args) throws IOException {
//        HttpMethodGetUtil get = new HttpMethodGetUtil();
//        get.httpMethodGet("http://www.baidu.com/");
//    }

    public void httpMethodGet(String urlAddress) throws IOException {
        //建立连接并发送请求
        HttpURLConnection urlConnection = null;
        try {
            URL url = new URL(urlAddress);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.setUseCaches(false);
//            urlConnection.setRequestProperty("Cookie","x=u");
            urlConnection.connect();

//            //获取响应内容
            BufferedReader bf = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
//            String readLine = bf.readLine();
//            while (readLine != null){
//                System.out.println(readLine);
//                readLine = bf.readLine();
//            }
            String readLine;
            StringBuffer sb = new StringBuffer();
            while ((readLine = bf.readLine()) != null){
                sb.append(readLine);
            }
            if (bf != null){
                bf.close();
            }
            if (urlConnection !=null){
                urlConnection.disconnect();
            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }finally {
            urlConnection.disconnect();
        }

//        return null;
    }
}
