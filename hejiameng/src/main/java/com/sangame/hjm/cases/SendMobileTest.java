package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.SendMobileCase;
import com.sangame.hjm.model.SendMobileResult;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SendMobileTest {
    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.sendMobileUrl = ConfigFile.getUrl(InterfaceName.SENDMOBILE);
        TestConfig.defaultHttpClient = new DefaultHttpClient();

    }

    @Test
    public void sendMobile() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        SendMobileCase sendMobileCase = sqlSession.selectOne("sendMobileCase",1);
        System.out.println("sendMobileCase:" + sendMobileCase.toString());

        //发送请求，获取接口返回结果
        SendMobileResult result = getSendMobileResponseResult(sendMobileCase);
        System.out.println("用户登录发送短信验证码接口返回的结果：" + result.toString());

        //验证结果
        Assert.assertEquals(result.getCode(),0);
        //Assert.assertEquals(result.getMsg(),"短信验证码发送成功，请查收");

    }
    private SendMobileResult getSendMobileResponseResult(SendMobileCase sendMobileCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.sendMobileUrl + "?mobile=" + sendMobileCase.getMobile());
        System.out.println("用户登录发送短信验证码Url get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        SendMobileResult resultClass = new Gson().fromJson(result,SendMobileResult.class);
        return resultClass;
    }
}
