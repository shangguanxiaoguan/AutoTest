package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.CreateYunXinIDCase;
import com.sangame.hjm.model.CreateYunXinIDResult;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmYunXin;
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
 * 创建云信客服用户接口测试
 */

public class CreateYunXinIDTest {
    @BeforeTest
    public void beforeTest(){
        TestConfig.createYunXinIDUrl = ConfigFile.getUrl(InterfaceName.CREATEYUNXINID);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }
    @Test
    public void createYunXinID() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        CreateYunXinIDCase createYunXinIDCase = sqlSession.selectOne("createYunXinIDCase",1);
        System.out.println("createYunXinIDCase:" + createYunXinIDCase.toString());

        //发送请求，获取接口返回的数据
        CreateYunXinIDResult result = getResponseResult(createYunXinIDCase);
        System.out.println("创建云信客服用户接口返回的结果：" + result.toString());

        //获取数据库结果
        SqlSession expectedSession = DatebaseUtil.getSqlSession();
        JmYunXin expectedResult =expectedSession.selectOne("getCreateYunXinID",createYunXinIDCase);
        System.out.println("验证创建云信客服用户的结果：" + expectedResult.toString());

        //验证结果
        Assert.assertEquals(result.getCode(),0);
        Assert.assertNotNull(expectedResult);

    }

    private CreateYunXinIDResult getResponseResult(CreateYunXinIDCase createYunXinIDCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.createYunXinIDUrl +"?userId=" + createYunXinIDCase.getUserId());
        System.out.println("创建云信客服用户Url get:" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        CreateYunXinIDResult resultClass = new Gson().fromJson(result,CreateYunXinIDResult.class);
        return resultClass;
    }
}
