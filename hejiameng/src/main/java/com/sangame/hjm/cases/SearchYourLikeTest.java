package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.SearchYourLikeCase;
import com.sangame.hjm.model.SearchYourLikeResult;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class SearchYourLikeTest {

    @Test
    public void searchYourLike() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        SearchYourLikeCase searchYourLikeCase = sqlSession.selectOne("searchYourLikeCase",1);

        //发送请求，获取接口返回数据
        SearchYourLikeResult result = getResponseResult(searchYourLikeCase);

        //验证结果
        //什么样的数据可以定义为是用户喜欢的？？？

    }

    private SearchYourLikeResult getResponseResult(SearchYourLikeCase searchYourLikeCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.searchYourLikeUrl + "?pageSize=" + searchYourLikeCase.getPageSize()
                + "&pageNum=" + searchYourLikeCase.getPageNum());
        System.out.println("searchYourLikeUrl get:" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        SearchYourLikeResult resultClass = new Gson().fromJson(result,SearchYourLikeResult.class);
        return resultClass;
    }
}
