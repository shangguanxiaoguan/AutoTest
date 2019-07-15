package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.*;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import com.sangame.hjm.utils.HttpMethodPostUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.CookieStore;
import java.util.HashMap;
import java.util.Map;

public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.updateVersionUrl = ConfigFile.getUrl(InterfaceName.UPDATEVERSION);
        TestConfig.getBannerTurnUrl = ConfigFile.getUrl(InterfaceName.GETBANNERTURN);
        TestConfig.getHomeSubCategoryUrl = ConfigFile.getUrl(InterfaceName.GETHOMESUBCATEGORY);
        TestConfig.keyWordSearchUrl = ConfigFile.getUrl(InterfaceName.KEYWORDSEARCH);
        TestConfig.searchProjectForConditionUrl = ConfigFile.getUrl(InterfaceName.SEARCHPROJECTFORCONDITION);
        TestConfig.searchCategoryUrl = ConfigFile.getUrl(InterfaceName.SEARCHCATEGORY);
        TestConfig.searchYourLikeUrl = ConfigFile.getUrl(InterfaceName.SEARCHYOURLIKE);
        TestConfig.storeDetailsUrl = ConfigFile.getUrl(InterfaceName.STOREDETAILS);
        TestConfig.onLineMessageUrl = ConfigFile.getUrl(InterfaceName.ONLINEMESSAGE);
        TestConfig.searchInvestmentUrl = ConfigFile.getUrl(InterfaceName.SEARCHINVESTMENT);
        TestConfig.projectCustomUrl = ConfigFile.getUrl(InterfaceName.PROJECTCUSTOM);
        TestConfig.BusinessEnterUrl = ConfigFile.getUrl(InterfaceName.BUSINESSENTER);
        TestConfig.searchHomeJoinHeadlineUrl = ConfigFile.getUrl(InterfaceName.GETHOMEJOINHEADLINE);
        TestConfig.searchSubCategoryByCategoryIdUrl = ConfigFile.getUrl(InterfaceName.SEARCHSUBCATEGORYBYCATEGORYID);
        TestConfig.createYunXinIDUrl = ConfigFile.getUrl(InterfaceName.CREATEYUNXINID);
        TestConfig.distributeYunXinIDUrl = ConfigFile.getUrl(InterfaceName.DISTRIBUTEYUNXINID);
        TestConfig.preferenceRecommendUrl = ConfigFile.getUrl(InterfaceName.PREFERENCERECOMMEND);
        TestConfig.userRegisterUrl = ConfigFile.getUrl(InterfaceName.USERREGISTER);
        TestConfig.sendMobileUrl = ConfigFile.getUrl(InterfaceName.SENDMOBILE);
        TestConfig.loginOrRegisterUrl = ConfigFile.getUrl(InterfaceName.LOGINORREGISTER);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
//        TestConfig.store

    }


    @Test
    public void loginOrRegister() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        LoginOrRegisterCase loginOrRegisterCase = sqlSession.selectOne("loginOrRegisterCase",1);
        System.out.println("loginOrRegisterCase：" + loginOrRegisterCase.toString());

        //发送请求，获取接口返回的结果
        Map<String,Object> map = new HashMap<>();
        map.put("mobile",loginOrRegisterCase.getMobile());
        map.put("authCode",loginOrRegisterCase.getAuthCode());
        System.out.println("map" + map.toString());
        String result = HttpMethodPostUtil.httpMethodPost(TestConfig.loginOrRegisterUrl,map);
        LoginOrRegisterResult loginOrRegisterResult = new Gson().fromJson(result,LoginOrRegisterResult.class);
        System.out.println("用户注册、登录接口返回的结果：" + loginOrRegisterResult.toString());

        //验证结果
//        SqlSession expectedSession = DatebaseUtil.getSqlSession();
//        JmUser expectedResult = expectedSession.selectOne("getUserInfo",loginOrRegisterCase.getMobile());
//        System.out.println("数据库获取结果：" + expectedResult.toString());
        Assert.assertEquals(loginOrRegisterResult.getCode(),0);


    }

    private LoginOrRegisterResult getResponseResult(LoginOrRegisterCase loginOrRegisterCase) {

        return null;
    }





}
