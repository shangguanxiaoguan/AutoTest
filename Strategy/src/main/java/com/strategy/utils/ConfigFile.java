package com.strategy.utils;

import com.strategy.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        String testUrl;
        if (name == InterfaceName.LOGIN){
            uri = bundle.getString("login.uri");
        }
        if (name == InterfaceName.BUY){
            uri = bundle.getString("buy.uri");
        }
        if (name == InterfaceName.SELL){
            uri = bundle.getString("sell.uri");
        }
        if (name == InterfaceName.CANCEL){
            uri = bundle.getString("cancel.uri");
        }
        if (name == InterfaceName.ADDMARGIN){
            uri = bundle.getString("addMargin.uri");
        }
        if (name == InterfaceName.GETLIST){
            uri =  bundle.getString("getList.uri");
        }

        testUrl = address + uri;
        return testUrl;
    }
}
