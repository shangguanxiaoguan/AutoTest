package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.UserRegisterCase;
import com.sangame.hjm.model.UserRegisterResult;
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

public class UserRegisterTest {

    @BeforeTest
    public void beforeTest(){
        TestConfig.userRegisterUrl = ConfigFile.getUrl(InterfaceName.USERREGISTER);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }
    @Test
    public void userRegister() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        UserRegisterCase userRegisterCase = sqlSession.selectOne("userRegisterCase",2);
        System.out.println("userRegisterCase:" + userRegisterCase);

        //发送请求，获取接口返回数据
        UserRegisterResult result = getResponseResult(userRegisterCase);
        System.out.println("用户注册上报接口返回的结果：" + result.toString());

        //验证结果
//        Assert.assertEquals(result.getCode(),0);
//        Assert.assertEquals(result.getMsg(),"用户注册成功");

    }

    private UserRegisterResult getResponseResult(UserRegisterCase userRegisterCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.userRegisterUrl + "?passportId=" + userRegisterCase.getPassportId());
        System.out.println("用户注册上报Url get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        UserRegisterResult resultClass = new Gson().fromJson(result,UserRegisterResult.class);
        return resultClass;
    }

}
