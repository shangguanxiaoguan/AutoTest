package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.BusinessEnterCase;
import com.sangame.hjm.model.BusinessEnterResult;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmEnterApply;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
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

public class BusinessEnterTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.BusinessEnterUrl = ConfigFile.getUrl(InterfaceName.BUSINESSENTER);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test
    public void businessEnter() throws IOException, InterruptedException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        BusinessEnterCase businessEnterCase = sqlSession.selectOne("businessEnterCase",1);

        //发送请求，获取接口返回数据
        BusinessEnterResult result = getResponseResult(businessEnterCase);
        System.out.println("商家入驻的result：" + result.toString());
        Thread.sleep(8000);

        //验证结果
        System.out.println("businessEnterCase.getExpect()：" + businessEnterCase.getExpect());
        JmEnterApply actualResult = sqlSession.selectOne(businessEnterCase.getExpect(),businessEnterCase);
        System.out.println("商家入驻的验证result：" + actualResult.toString());



        Assert.assertEquals(0,result.getCode());
        Assert.assertEquals("success",result.getMsg());
        Assert.assertNotNull(actualResult);

    }

    private BusinessEnterResult getResponseResult(BusinessEnterCase businessEnterCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.BusinessEnterUrl);
        JSONObject param = new JSONObject();
        param.put("cngoldId",businessEnterCase.getCngoldId());
        param.put("brand",businessEnterCase.getBrand());
        param.put("company",businessEnterCase.getCompany());
        param.put("name",businessEnterCase.getName());
        param.put("cityId",businessEnterCase.getCityId());
        param.put("phoneNumber",businessEnterCase.getPhoneNumber());
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        System.out.println("BusinessEnterUrl post：" + post);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        BusinessEnterResult resultClass = new Gson().fromJson(result,BusinessEnterResult.class);
        return resultClass;
    }
}
