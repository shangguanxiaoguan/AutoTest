package com.sangame.hjm.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.SysConfig;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.UpdateVersionCase;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
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

    }


    @Test(description = "检查Android的版本更新信息")
    public void updateVersionAndroid() throws IOException {

        for (int i =1; i <= 4; i++){  //遍历去取测试数据
            SqlSession sqlSession = DatebaseUtil.getSqlSession();
            UpdateVersionCase updateVersion = sqlSession.selectOne("updateVersionCase",i);
            System.out.println("updateVersion内容：" + updateVersion.toString());
            System.out.println("updateVersionUrl：" + TestConfig.updateVersionUrl);

            //发送请求，获取接口返回结果
            JSONObject resultJson = getJsonResult(updateVersion);
            System.out.println("版本更新resultJson:" + resultJson);

            if (i == 1){
                //获取实际的Android版本更新信息
                SysConfig sysConfig = sqlSession.selectOne("getUpdateVersionInfo",2);//数据库中id为2的是Android的更新地址
                System.out.println("sysConfig内容："+ sysConfig.toString());
                System.out.println("sysConfig.getShow_name():" + sysConfig.getShow_name());
                HttpGet httpGet = new HttpGet(sysConfig.getShow_name());
                HttpResponse httpResponse = TestConfig.defaultHttpClient.execute(httpGet);
                String actualVersionInfo;
                actualVersionInfo = EntityUtils.toString(httpResponse.getEntity());
                JSONObject actualVersionInfoJson = JSONObject.parseObject(actualVersionInfo);

                //验证结果
                Assert.assertEquals(updateVersion.getExpectCode(),resultJson.getString("code"));
                JSONArray resultList = resultJson.getJSONArray("data");
                JSONObject resultListData = resultList.getJSONObject(0);

                Assert.assertEquals(actualVersionInfoJson.getString("version"),resultListData.getString("version"));
                Assert.assertEquals(actualVersionInfoJson.getString("mversion"),resultListData.getString("mversion"));
                Assert.assertEquals(actualVersionInfoJson.getString("content"),resultListData.getString("content"));
                Assert.assertEquals(actualVersionInfoJson.getString("review"),resultListData.getString("review"));
                Assert.assertEquals(actualVersionInfoJson.getString("jump"),resultListData.getString("jump"));
                Assert.assertEquals(actualVersionInfoJson.getString("adress"),resultListData.getString("adress"));
            }else if (i == 2){
                //获取实际的IOS版本更新信息
                SysConfig sysConfig = sqlSession.selectOne("getUpdateVersionInfo",1);//数据库中id为1的是IOS的更新地址
                System.out.println("sysConfig内容："+ sysConfig.toString());
                System.out.println("sysConfig.getShow_name():" + sysConfig.getShow_name());
                HttpGet httpGet = new HttpGet(sysConfig.getShow_name());
                HttpResponse httpResponse = TestConfig.defaultHttpClient.execute(httpGet);
                String actualVersionInfo;
                actualVersionInfo = EntityUtils.toString(httpResponse.getEntity());
                JSONObject actualVersionInfoJson = JSONObject.parseObject(actualVersionInfo);

                //验证结果
                Assert.assertEquals(updateVersion.getExpectCode(),resultJson.getString("code"));
                JSONArray resultList = resultJson.getJSONArray("data");
                JSONObject resultListData = resultList.getJSONObject(0);

                Assert.assertEquals(actualVersionInfoJson.getString("version"),resultListData.getString("version"));
                Assert.assertEquals(actualVersionInfoJson.getString("mversion"),resultListData.getString("mversion"));
                Assert.assertEquals(actualVersionInfoJson.getString("content"),resultListData.getString("content"));
                Assert.assertEquals(actualVersionInfoJson.getString("review"),resultListData.getString("review"));
                Assert.assertEquals(actualVersionInfoJson.getString("jump"),resultListData.getString("jump"));
                Assert.assertEquals(actualVersionInfoJson.getString("adress"),resultListData.getString("adress"));
                Assert.assertEquals(actualVersionInfoJson.getString("appID"),resultListData.getString("appID"));
                Assert.assertEquals(actualVersionInfoJson.getString("isHiddenIndex"),resultListData.getString("isHiddenIndex"));
            }else{
                Assert.assertEquals(updateVersion.getExpectCode(),resultJson.getString("code"));
            }
        }

    }

//    @Test(description = "检查IOS的版本更新信息")
//    public void updateVersionIOS() throws IOException {
//        SqlSession sqlSession = DatebaseUtil.getSqlSession();
//        UpdateVersionCase updateVersionCase = sqlSession.selectOne("updateVersionCase",2);
//    }

    private JSONObject getJsonResult(UpdateVersionCase updateVersionCase) throws IOException {

//        JSONObject param = new JSONObject();
//        param.put("deviceType",updateVersionCase.getDeviceType());
//
//        StringEntity entity = new StringEntity(param.toString(),"utf-8");
//        System.out.println(entity);
        HttpGet get = new HttpGet(TestConfig.updateVersionUrl + "?deviceType=" + updateVersionCase.getDeviceType());
        get.setHeader("content-type","application/json");
        System.out.println("get:"+get);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        result = EntityUtils.toString(response.getEntity());
//        List resultList = Arrays.asList(result);
//        JSONArray resultArray = new JSONArray(resultList);
        JSONObject resultJson = JSONObject.parseObject(result);

//        String tempStr=new Gson().toJson("123456");
        return resultJson;
    }
}
