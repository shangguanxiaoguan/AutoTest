package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmProject;
import com.sangame.hjm.model.KeyWordSearchCase;
import com.sangame.hjm.model.KeyWordSearchResult;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DateFormatChange;
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
 * 关键字搜索接口测试
 */


public class KeyWordSearchTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.keyWordSearchUrl = ConfigFile.getUrl(InterfaceName.KEYWORDSEARCH);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test
    public void keyWordSearch() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        KeyWordSearchCase keyWordSearchCase = sqlSession.selectOne("keyWordSearchCase",1);
        System.out.println("keyWordSearchCase:" + keyWordSearchCase);

        //发送请求，获取接口返回结果
        KeyWordSearchResult result = getResponseResult(keyWordSearchCase);
        System.out.println("关键字搜索接口返回结果：" + result.toString());
        System.out.println("关键字搜索接口返回的data数据：" + result.getData().toString());

        //获取数据库实际结果
        List<JmProject> expectedResult = sqlSession.selectList(keyWordSearchCase.getExpect(),keyWordSearchCase);
        System.out.println("数据库查询出来的结果：" + expectedResult.toString());
        int expectedTotal = sqlSession.selectOne("keyWordSearchTotal",keyWordSearchCase);
        System.out.println("数据库搜索关键字总条数：" + expectedTotal);

        //验证结果

        Assert.assertEquals(result.getData().size(),expectedResult.size());
        Assert.assertEquals(result.getCode(),0);
        if (expectedResult.isEmpty() || result.getData().isEmpty()){
            Assert.assertEquals(result.getPageSize(),keyWordSearchCase.getPageSize());
            Assert.assertEquals(result.getPageNum(),0);
            Assert.assertEquals(result.getTotal(),0);
            Assert.assertEquals(result.getTotalPage(),0);
        }else{
            Assert.assertEquals(result.getPageSize(),keyWordSearchCase.getPageSize());
            Assert.assertEquals(result.getPageNum(),keyWordSearchCase.getPageNum());
            Assert.assertEquals(result.getTotal(),expectedTotal);
            Assert.assertEquals(result.getTotalPage(),Math.ceil(expectedTotal/keyWordSearchCase.getPageSize()));
            for (int i = 0; i < expectedResult.size(); i++){

                if (result.getData().get(i).isDeleteFlag().equals("false")){
                    result.getData().get(i).setDeleteFlag("0");
                }else if (result.getData().get(i).isDeleteFlag().equals("true")){
                    result.getData().get(i).setDeleteFlag("1");
                }

                Assert.assertEquals(result.getData().get(i).getCreateAt(), DateFormatChange.stringDateFormatChange(expectedResult.get(i).getCreateAt()));
                Assert.assertEquals(result.getData().get(i).getUpdateAt(),DateFormatChange.stringDateFormatChange(expectedResult.get(i).getUpdateAt()));
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getModifier(),expectedResult.get(i).getModifier());
                Assert.assertEquals(result.getData().get(i).isDeleteFlag(),String.valueOf(expectedResult.get(i).getDeleteFlag()));
                Assert.assertEquals(result.getData().get(i).getId(),expectedResult.get(i).getId());
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
            }
        }
    }

    private KeyWordSearchResult getResponseResult(KeyWordSearchCase keyWordSearchCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.keyWordSearchUrl + "?keyword=" + keyWordSearchCase.getKeyword()
                + "&pageStart=" + keyWordSearchCase.getPageNum() + "&pageSize=" + keyWordSearchCase.getPageSize() );
        System.out.println("KeyWordSearchUrl get:" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        KeyWordSearchResult resultClass = new Gson().fromJson(result,KeyWordSearchResult.class);
        return resultClass;
    }

}
