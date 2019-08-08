package com.sangame.hjm.manager;

import com.google.gson.Gson;
import com.sangame.hjm.base.BaseApi;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.LoginOrRegisterCase;
import com.sangame.hjm.model.LoginOrRegisterResult;
import com.sangame.hjm.utils.DatebaseUtil;
import com.sangame.hjm.utils.HttpMethodPostUtil;
import com.sangame.hjm.utils.ReadExcelUtil;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class LoginByExcel extends BaseApi {
    @DataProvider(name = "post")
    public Object[][] post() throws IOException {
        //Excel表格中的sheet页来填写数字参数，第一页下标为0
        System.out.println("========哈哈哈哈");
        Object[][] objects = ReadExcelUtil.readExData(testCaseExcel,1);
        System.out.println(objects.toString());
          return ReadExcelUtil.readExData(testCaseExcel,1);
        //return null;
}

    @Test(dataProvider = "post")
    //此处传递的参数必须和Excel表中的顺序一致，不然会报错
    public void login(String mobile, String authCode, String expect) throws Exception {
        System.out.println("黄金矿工的科技感的空间发");
        //使用构造函数将传入的用户名密码初始化成登录请求参数
//        LoginOrRegisterCase loginParameters = new LoginOrRegisterCase(account,loginPwd,partnerCode);
//        Map<String, String> map=FastjsonUtils.toMap(FastjsonUtils.toJson(loginParameters));
//        //Log.info("my out**********"+map);
//        //发送登录请求
//        CloseableHttpResponse closeableHttpResponse = RestClient.postForm(hostManager+loginUrl, map, null);
//        //从返回结果中获取状态码
//        int statusCode = RestClient.getStatusCode(closeableHttpResponse);
//        //Assert.assertEquals(statusCode,Constants.RESPNSE_STATUS_CODE_200,"status code is not 200");
//        //断言响应json内容中name和job是不是期待结果
//        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity());
//        System.out.println("my out**********"+responseString);
//        //JSONObject res = FastjsonUtils.toJsonObject(responseString);
//        //sessionKey = FastjsonUtils.toMap(res.getString("data")).get("session_key");
//        System.out.println("data**********: " + res.getString("message"));
//        System.out.println("data**********: " + sessionKey);
//        String partnerType=FastjsonUtils.toMap(res.getString("data")).get("partnerType");
//        Assert.assertEquals(partnerType,"路内" ,"partnerType is not 路内");
        //SqlSession sqlSession = DatebaseUtil.getSqlSession();
        //LoginOrRegisterCase loginOrRegisterCase = sqlSession.selectOne("loginOrRegisterCase",1);
        //System.out.println("loginOrRegisterCase：" + loginOrRegisterCase.toString());

        //发送请求，获取接口返回的结果
        Map<String,Object> map = new HashMap<>();
        map.put("mobile",mobile);
        map.put("authCode",authCode);
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
//    @BeforeClass
//    public void endTest(){
//        System.out.print("测试结束");
//    }

}
