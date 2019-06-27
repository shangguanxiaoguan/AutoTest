package com.sangame.hjm.cases;

import com.alibaba.fastjson.JSONObject;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 首页主要分类接口测试
 */

public class GetHomeSubCategoryTest {

    @Test
    public void getHomeSubCategory() throws IOException {

        SqlSession sqlSession = DatebaseUtil.getSqlSession();

        //发送请求，获取接口返回数据
        JSONObject resultJson = getJsonResult();

        //获取数据库实际分类
        //数据是怎么取的？？？

    }

    private JSONObject getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfig.getHomeSubCategoryUrl);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        JSONObject resultJson = JSONObject.parseObject(result);
        return resultJson;
    }
}
