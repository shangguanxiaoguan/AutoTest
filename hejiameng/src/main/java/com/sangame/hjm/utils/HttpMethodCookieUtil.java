package com.sangame.hjm.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HttpMethodCookieUtil {

    public static String globalCookie = "";

    public String httpMethodPost(String url, Map<String, Object> paramsMap) throws IOException {
        String gb = "UTF-8";
        String params = null;
        if (null != paramsMap) {
            params = getParamStr(paramsMap);
        }

        StringBuffer sb = new StringBuffer();
        URL urls;
        HttpURLConnection uc = null;
        BufferedReader in = null;
        try {
            urls = new URL(url);
            uc = (HttpURLConnection) urls.openConnection();
            uc.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
            uc.setDoOutput(true);
            uc.setDoInput(true);
            uc.setRequestMethod("POST");
            uc.setUseCaches(false);
            uc.connect();
//            DataOutputStream out = new DataOutputStream(uc.getOutputStream());
//            out.write(params.getBytes(gb));
//            out.flush();
//            out.close();

            PrintWriter pw = new PrintWriter(uc.getOutputStream());
            pw.print(params.getBytes(gb));
            pw.flush();

            in = new BufferedReader(new InputStreamReader(uc.getInputStream(), gb));
            String readLine = "";
            while ((readLine = in.readLine()) != null) {
                sb.append(readLine);
            }
            //获取单个头信息
            uc.getHeaderField("Set-Cookie");//Cookie的字段名
            //获取所有的头信息
            Map<String, List<String>> headerMap = uc.getHeaderFields();
            //获取cookie
            List cookieList = headerMap.get("Set-Cookie");

            for (int i = 0;i<cookieList.size();i++){
                //具体处理方式以接口返回的cookie格式为准
                String temp = cookieList.get(i).toString();
                String value[] = temp.split(";");
//                System.out.println(cookieList.get(i));
                System.out.println(value[0]);
                this.globalCookie += value[0] + ";";
            }

            if (in != null) {
                in.close();
            }
            if (uc != null) {
                uc.disconnect();
            }
        } finally {
            if (uc != null) {
                uc.disconnect();
            }
        }
        return sb.toString();
    }


    private static String getParamStr(Map<String, Object> paramsMap) {
        StringBuilder param = new StringBuilder();
        for (Iterator<Map.Entry<String, Object>> it = paramsMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<String, Object> e = it.next();
            param.append("&").append(e.getKey()).append("=").append(e.getValue());
        }
        return param.toString().substring(1);
    }
}
