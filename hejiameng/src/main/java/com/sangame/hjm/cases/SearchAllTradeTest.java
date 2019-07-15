package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmCategory;
import com.sangame.hjm.model.SearchAllTradeResult;
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
import java.util.List;

/**
 * 查询二级分类数据接口测试（1.0版本暂时没有用到）
 */

public class SearchAllTradeTest {

    @BeforeTest
    public void beforeTest(){
        TestConfig.searchAllTradeUrl = ConfigFile.getUrl(InterfaceName.SEARCHALLTRADE);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test
    public void searchAllTrade() throws IOException {
        //发送请求，获取接口返回结果
        SearchAllTradeResult result = getResponseResult();
        System.out.println("查询所有加盟行业接口返回的数据：" + result.toString());
        System.out.println("查询所有加盟行业接口返回的data数据：" + result.getData().toString());

        //获取数据库数据
//        SqlSession sqlSession = DatebaseUtil.getSqlSession();
//        List<JmCategory> expectedResult = sqlSession.selectList("searchCategory");



    }

    private SearchAllTradeResult getResponseResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.searchAllTradeUrl);
        System.out.println("查询所有加盟行业Url get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        SearchAllTradeResult resultClass = new Gson().fromJson(result,SearchAllTradeResult.class);
        return resultClass;
    }
}
