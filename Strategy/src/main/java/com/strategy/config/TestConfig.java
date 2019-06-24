package com.strategy.config;

import org.apache.http.impl.client.DefaultHttpClient;

import java.net.CookieStore;

public class TestConfig {
    public static String loginUrl;
    public static String buyUrl;
    public static String sellUrl;
    public static String cancelUrl;
    public static String addMarginUrl;
    public static String getListUrl;
    public static String getHoldUrl;
    public static String getHistoryUrl;
    public static String getEntrustDetailUrl;
    public static String getQuotationUrl;
    public static String getRiseFall;
    public static String getUserFund;

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore store;

}
