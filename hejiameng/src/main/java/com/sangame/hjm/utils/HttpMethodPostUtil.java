package com.sangame.hjm.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class HttpMethodPostUtil {
    public static String httpMethodPost(String url, Map<String, Object> paramsMap) throws IOException {
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
            DataOutputStream out = new DataOutputStream(uc.getOutputStream());
            out.write(params.getBytes(gb));
            out.flush();
            out.close();
            in = new BufferedReader(new InputStreamReader(uc.getInputStream(), gb));
            String readLine = "";
            while ((readLine = in.readLine()) != null) {
                sb.append(readLine);
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
