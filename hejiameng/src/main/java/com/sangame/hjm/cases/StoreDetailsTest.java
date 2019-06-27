package com.sangame.hjm.cases;
import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.StoreDetailsCase;
import com.sangame.hjm.model.StoreDetailsResult;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

/**
 * 商铺详情接口测试
 */

public class StoreDetailsTest {
    @Test
    public void storeDetails() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        StoreDetailsCase storeDetailsCase = sqlSession.selectOne("storeDetailsCase",1);

        //发送请求，获取接口返回数据
        StoreDetailsResult result = getResponseResult(storeDetailsCase);

        //验证结果
        List<StoreDetailsResult> actualData = sqlSession.selectList("storeDetails"); //SQL还没写

        //Assert.assertEquals(actualData.);

    }

    private StoreDetailsResult getResponseResult(StoreDetailsCase storeDetailsCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.storeDetailsUrl + "?projectId=" + storeDetailsCase.getProjectId());
        System.out.println("storeDetailsUrl get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        StoreDetailsResult resultClass = new Gson().fromJson(result,StoreDetailsResult.class);
        return resultClass;
    }
}
