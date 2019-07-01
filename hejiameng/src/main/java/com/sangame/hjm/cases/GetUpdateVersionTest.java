package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.model.*;
import com.sangame.hjm.config.TestConfig;
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


/**
 * APP更新接口测试
 */


public class GetUpdateVersionTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.updateVersionUrl = ConfigFile.getUrl(InterfaceName.UPDATEVERSION);
        TestConfig.getBannerTurnUrl = ConfigFile.getUrl(InterfaceName.GETBANNERTURN);
        TestConfig.getHomeSubCategoryUrl = ConfigFile.getUrl(InterfaceName.GETHOMESUBCATEGORY);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }


    @Test(description = "检查Android的版本更新信息")
    public void updateVersionAndroid() throws IOException {

        for (int i =1; i <= 3; i++){  //遍历去取测试数据
            SqlSession sqlSession = DatebaseUtil.getSqlSession();
            System.out.println("i:" + i);
            UpdateVersionCase updateVersion = sqlSession.selectOne("updateVersionCase",i);

            //发送请求，获取接口返回结果
            UpdateVersionResult result = getJsonResult(updateVersion);
//            System.out.println("版本更新resultJson:" + result.getData().toString());

            if (i == 1){
                //获取实际的Android版本更新信息
                SysConfig sysConfig = sqlSession.selectOne("getUpdateVersionInfo",2);//数据库中id为2的是Android的更新地址
                System.out.println("sysConfig内容："+ sysConfig.toString());
                HttpGet httpGet = new HttpGet(sysConfig.getShow_name());
                HttpResponse httpResponse = TestConfig.defaultHttpClient.execute(httpGet);
                String actualVersionInfo = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
                UpdateVersionFileInfo actualVersionInfoJson = new Gson().fromJson(actualVersionInfo,UpdateVersionFileInfo.class);
                System.out.println("actualVersionInfoJson:" + actualVersionInfoJson.toString());

                //验证结果
                Assert.assertEquals(0,result.getCode());
                Assert.assertEquals(actualVersionInfoJson.getVersion(),result.getData().getVersion());
                Assert.assertEquals(actualVersionInfoJson.getMversion(),result.getData().getMversion());
                Assert.assertEquals(actualVersionInfoJson.getContent(),result.getData().getContent());
                Assert.assertEquals(actualVersionInfoJson.getReview(),result.getData().getReview());
                Assert.assertEquals(actualVersionInfoJson.getJump(),result.getData().getJump());
                Assert.assertEquals(actualVersionInfoJson.getAdress(),result.getData().getAdress());

            }else if (i == 2){
                //获取实际的IOS版本更新信息
                SysConfig sysConfig = sqlSession.selectOne("getUpdateVersionInfo",1);//数据库中id为1的是IOS的更新地址
                System.out.println("sysConfig内容："+ sysConfig.toString());
                HttpGet httpGet = new HttpGet(sysConfig.getShow_name());
                HttpResponse httpResponse = TestConfig.defaultHttpClient.execute(httpGet);
                String actualVersionInfo = EntityUtils.toString(httpResponse.getEntity(),"utf-8");
                System.out.println("actualVersionInfo:" + actualVersionInfo );
                UpdateVersionFileInfo actualVersionInfoJson = new Gson().fromJson(actualVersionInfo,UpdateVersionFileInfo.class);
                System.out.println("actualVersionInfoJson:" + actualVersionInfoJson.toString());

                //验证结果
                Assert.assertEquals(0,result.getCode());
                Assert.assertEquals(actualVersionInfoJson.getVersion(),result.getData().getVersion());
                Assert.assertEquals(actualVersionInfoJson.getMversion(),result.getData().getMversion());
                Assert.assertEquals(actualVersionInfoJson.getContent(),result.getData().getContent());
                Assert.assertEquals(actualVersionInfoJson.getReview(),result.getData().getReview());
                Assert.assertEquals(actualVersionInfoJson.getJump(),result.getData().getJump());
                Assert.assertEquals(actualVersionInfoJson.getAdress(),result.getData().getAdress());
                Assert.assertEquals(actualVersionInfoJson.getAppID(),result.getData().getAppID());
                Assert.assertEquals(actualVersionInfoJson.getIsHiddenIndex(),result.getData().getIsHiddenIndex());

            }else{
                System.out.println(updateVersion.getDeviceType());
                Assert.assertEquals(updateVersion.getExpectCode(),result.getCode());
            }
        }

    }


    private UpdateVersionResult getJsonResult(UpdateVersionCase updateVersionCase) throws IOException {

        HttpGet get = new HttpGet(TestConfig.updateVersionUrl + "?deviceType=" + updateVersionCase.getDeviceType());
        //get.setHeader("content-type","application/json");
        System.out.println("get:"+get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        UpdateVersionResult resultClass = new Gson().fromJson(result,UpdateVersionResult.class);
        return resultClass;
    }
}
