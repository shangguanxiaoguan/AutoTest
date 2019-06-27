package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.KeyWordSearchCase;
import com.sangame.hjm.model.KeyWordSearchResult;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * 关键字搜索接口测试
 */


public class KeyWordSearchTest {

    @Test
    public void keyWordSearch() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        KeyWordSearchCase keyWordSearchCase = sqlSession.selectOne("keyWordSearchCase",1);

        //发送请求，获取接口返回结果
        KeyWordSearchResult result = getResponseResult(keyWordSearchCase);

        //验证结果


    }

    private KeyWordSearchResult getResponseResult(KeyWordSearchCase keyWordSearchCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.keyWordSearchUrl + "?keyword=" + keyWordSearchCase.getKeyword()
                + "&pageStart=" + keyWordSearchCase.getPageStart() + "&pageSize=" + keyWordSearchCase.getPageSize() );
        System.out.println("KeyWordSearchUrl get:" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        KeyWordSearchResult resultClass = new Gson().fromJson(result,KeyWordSearchResult.class);
        return resultClass;
    }

}
