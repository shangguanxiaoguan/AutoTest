package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    //找到配置文件
    private ResourceBundle bundle;
    //用来存储cookies信息
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest(){
        //去找配置文件
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    /**
     * 获取get请求中的cookies信息
     * @throws IOException
     */
    @Test
    public void testGetCookies() throws IOException {
        String result;
        //获得带cookies信息的get请求地址
        String uri = bundle.getString("getCookies.uri");
        //拼接测试地址
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        //声明client对象
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);

        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        cookieStore = client.getCookieStore();
        List<Cookie> cookieList = cookieStore.getCookies();
        for (Cookie cookie:cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookies name = " + name
            + "; cookies value = " + value);
        }
    }

    /**
     * 携带cookies信息访问post请求
     */
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testPostMethod() throws IOException {
        //获取post请求地址
        String uri = bundle.getString("test.post.with.cookies");
        //拼接测试地址
        String testUrl = this.url + uri;
        //声明一个post方法
        HttpPost post = new HttpPost(testUrl);
        //创建一个client对象，用来进行方法的执行
        DefaultHttpClient client = new DefaultHttpClient();
        //把cookies信息放进client中
        client.setCookieStore(this.cookieStore);
        //添加参数（需要在pom文件中添加JSON依赖）
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","25");

        //设置请求头信息 设置header
        post.setHeader("content-type","application/json");

        //将参数信息添加到post方法中
        StringEntity entity = new StringEntity(param.toString(),"UTF-8");
        post.setEntity(entity);
        //声明一个对象来存储响应结果
        String result;
        //执行post方法
        HttpResponse response = client.execute(post);
        //获取响应结果
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);
        //将响应结果转换为json对象
        JSONObject resultJson = new JSONObject(result);
        //获取到结果值
       String success = (String) resultJson.get("huhansan");
       String status = (String) resultJson.get("status");
       //具体判断返回结果的值
        Assert.assertEquals("success",success);
        Assert.assertEquals("1",status);





    }
}
