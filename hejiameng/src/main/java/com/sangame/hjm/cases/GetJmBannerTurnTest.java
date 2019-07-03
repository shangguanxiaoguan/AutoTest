package com.sangame.hjm.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.JmBanner;
import com.sangame.hjm.model.GetBannerTurnResult;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DateFormatChange;
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
import java.util.List;


/**
 * 首页轮播图接口测试
 */

public class GetJmBannerTurnTest {

//    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
//    public void beforeTest(){
//        TestConfig.updateVersionUrl = ConfigFile.getUrl(InterfaceName.UPDATEVERSION);
//        TestConfig.getBannerTurnUrl = ConfigFile.getUrl(InterfaceName.GETBANNERTURN);
//        TestConfig.getHomeSubCategoryUrl = ConfigFile.getUrl(InterfaceName.GETHOMESUBCATEGORY);
//        TestConfig.defaultHttpClient = new DefaultHttpClient();
//    }

    @Test(description = "首页轮播图接口测试")
    public void getBannerTurn() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        //发送请求，获取接口返回结果
        GetBannerTurnResult result = getJsonResult();
        System.out.println("接口返回的result：" + result.toString());

        //获取数据库存储的banner信息
        List<JmBanner> expectedResult = sqlSession.selectList("getBannerTurn");
        System.out.println("数据库取出的expectedResult：" + expectedResult.toString());

        //验证结果
        Assert.assertEquals(expectedResult.size(),result.getData().size());
        for (int i = 0; i < expectedResult.size(); i++){
            if (result.getData().get(i).isDeleteFlag().equals("false")){
                result.getData().get(i).setDeleteFlag("0");
            }else if (result.getData().get(i).isDeleteFlag().equals("true")){
                result.getData().get(i).setDeleteFlag("1");
            }

            Assert.assertEquals(result.getData().get(i).getCreateAt(), DateFormatChange.dateFormatChange(expectedResult.get(i).getCreated_at()));
            Assert.assertEquals(result.getData().get(i).getUpdateAt(),DateFormatChange.dateFormatChange(expectedResult.get(i).getUpdated_at()));
            Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
            Assert.assertEquals(result.getData().get(i).getModifier(),expectedResult.get(i).getModifier());
            Assert.assertEquals(result.getData().get(i).isDeleteFlag(),String.valueOf(expectedResult.get(i).getDelete_flag()));
            Assert.assertEquals(result.getData().get(i).getId(),expectedResult.get(i).getId());
            Assert.assertEquals(result.getData().get(i).getPosition(),expectedResult.get(i).getPosition());
            Assert.assertEquals(result.getData().get(i).getTitle(),expectedResult.get(i).getTitle());
            Assert.assertEquals(result.getData().get(i).getUrl(),expectedResult.get(i).getUrl());
            Assert.assertEquals(result.getData().get(i).getPhoto(),expectedResult.get(i).getPhoto());
            Assert.assertEquals(result.getData().get(i).getDisableFlag(),expectedResult.get(i).getDisable_flag());
        }

    }

    private GetBannerTurnResult getJsonResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.getBannerTurnUrl);
        System.out.println("get:"+get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        GetBannerTurnResult resultClass = new Gson().fromJson(result,GetBannerTurnResult.class);
        return resultClass;
    }
}
