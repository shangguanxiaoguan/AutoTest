package com.sangame.hjm.manager;

import com.google.gson.Gson;
import com.sangame.hjm.base.BaseApi;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.OnLineMessageResult;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.HttpMethodPostUtil;
import com.sangame.hjm.utils.ReadExcelUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OnLineMessageByExcel extends BaseApi {

    @BeforeTest
    public void beforeTest(){
        TestConfig.onLineMessageUrl = ConfigFile.getUrl(InterfaceName.ONLINEMESSAGE);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @DataProvider(name = "post")
    public Object[][] post() throws IOException {
        //Excel表格中的sheet页来填写数字参数，第一页下标为0
        System.out.println("========哈哈哈哈");
//        Object[][] objects = ReadExcelUtil.readExData(testCaseExcel,1);
//        System.out.println(objects.toString());
//          return ReadExcelUtil.readExData(testCaseExcel,1);
        List<Map<String,String>> data = ReadExcelUtil.getData(testCaseExcel);
        System.out.println("从Excel中获取的数据：" + data.toString());

        return null;
}

    @Test(dataProvider = "post")
    //此处传递的参数必须和Excel表中的顺序一致，不然会报错
    public void onLineMessage(String cngoldId, String commentId,String content) throws Exception {
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
        map.put("cngoldId",cngoldId);
        map.put("commentId",commentId);
        map.put("content",content);
        System.out.println("在线留言测试数据：" + map.toString());
        String result = HttpMethodPostUtil.httpMethodPost(TestConfig.onLineMessageUrl,map);
        OnLineMessageResult onLineMessageResult = new Gson().fromJson(result,OnLineMessageResult.class);
        System.out.println("在线留言接口返回的结果：" + onLineMessageResult.toString());

        //验证结果
//        SqlSession expectedSession = DatebaseUtil.getSqlSession();
//        JmUser expectedResult = expectedSession.selectOne("getUserInfo",loginOrRegisterCase.getMobile());
//        System.out.println("数据库获取结果：" + expectedResult.toString());
        Assert.assertEquals(onLineMessageResult.getCode(),0);

    }
//    @BeforeClass
//    public void endTest(){
//        System.out.print("测试结束");
//    }

}
