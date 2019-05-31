package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {

    private String url;
    private ResourceBundle bundle;
    //用来存储cookies信息
    CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        //去找到配置文件
        bundle = ResourceBundle.getBundle("application", Locale.CHINA); //application是resources文件下配置文件名称的前半部分
        //获取地址
        url = bundle.getString("test.url");
    }

    /**
     * 获取cookies信息
     * @throws IOException
     */
    @Test
    public void testGetCookies() throws IOException {

        String result;
        //从配置文件中拼接测试的URL
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url + uri;

        // 访问测试URL
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //获取cookies信息
        this.cookieStore = client.getCookieStore();
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie: cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name:" + name
            + "; cookie value:" + value);
        }
    }

    /**
     * 携带cookies信息访问get请求
     * @throws IOException
     */
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testGetWithCookies() throws IOException {
        String result;
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        //携带cookies信息
        client.setCookieStore(this.cookieStore);

        HttpResponse response = client.execute(get);

        //获取响应的状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode=" + statusCode);
        if (statusCode == 200){
            result = EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }
    }
}
