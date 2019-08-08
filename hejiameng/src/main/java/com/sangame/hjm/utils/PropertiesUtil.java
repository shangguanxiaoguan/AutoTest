package com.sangame.hjm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;


public class PropertiesUtil {
    private static String configPath = "application.properties";
    private static Properties p = null;
    static {
        p = new Properties();
        InputStream is = null;
        is = PropertiesUtil.class.getClassLoader().getResourceAsStream(configPath);
        try {
            p.load(is);
        } catch (IOException e) {
            //log.warn
            e.printStackTrace();
        }finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 通过指定的key来获取配置文件中对应的value，支持使用默认值
     * @param key
     * @param defValue
     * @return
     */
    public static String getConfigValue(String key,String defValue){
        String value = null;
        try {
            value = p.getProperty(key);
            if (value == null || "".equals(value)){
                value = defValue;
            }
        }catch (Exception e){
            System.out.println("读取配置文件出错，请检查配置文件的路径是否正确！错误信息为：" + e.getMessage());
            value = defValue;
        }
        return value;
    }

    public static String getConfigValue(String key){
        return getConfigValue(key,null);
    }

}
