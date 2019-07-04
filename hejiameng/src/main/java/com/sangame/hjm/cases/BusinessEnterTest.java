package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.BusinessEnterCase;
import com.sangame.hjm.model.BusinessEnterResult;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmEnterApply;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import com.sangame.hjm.utils.HttpMethodPostUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/***
 * 商家入驻接口测试
 */


public class BusinessEnterTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.BusinessEnterUrl = ConfigFile.getUrl(InterfaceName.BUSINESSENTER);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(description = "商家入驻接口测试")
    public void businessEnter() throws IOException, InterruptedException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        BusinessEnterCase businessEnterCase = sqlSession.selectOne("businessEnterCase",1);
        System.out.println("businessEnterCase:" + businessEnterCase.toString());

        //发送请求，获取接口返回数据
        Map<String,Object> map = new HashMap<>();
        map.put("cngoldId",businessEnterCase.getCngoldId());
        map.put("brand",businessEnterCase.getBrand());
        map.put("company",businessEnterCase.getCompany());
        map.put("name",businessEnterCase.getName());
        map.put("cityId",businessEnterCase.getCityId());
        map.put("phoneNumber",businessEnterCase.getPhoneNumber());
        String result = HttpMethodPostUtil.httpMethodPost(TestConfig.BusinessEnterUrl,map);
        BusinessEnterResult businessEnterResult = new Gson().fromJson(result,BusinessEnterResult.class);
        System.out.println("上家入驻接口返回的数据：" + businessEnterResult.toString());

        //验证结果
        SqlSession expectedSession = DatebaseUtil.getSqlSession();
        System.out.println("businessEnterCase.getExpect()：" + businessEnterCase.getExpect());
        JmEnterApply expectedResult = expectedSession.selectOne("getBusinessEnter",businessEnterCase);
        System.out.println("商家入驻的验证result：" + expectedResult.toString());

        Assert.assertEquals(0,businessEnterResult.getCode());
        Assert.assertEquals("success",businessEnterResult.getMsg());
        Assert.assertNotNull(expectedResult);

    }

}
