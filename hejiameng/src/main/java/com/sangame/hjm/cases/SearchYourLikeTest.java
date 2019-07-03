package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmProject;
import com.sangame.hjm.model.SearchYourLikeCase;
import com.sangame.hjm.model.SearchYourLikeResult;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DateFormatChange;
import com.sangame.hjm.utils.DatebaseUtil;
import com.sangame.hjm.utils.PageInfoUtil;
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
 * 猜你喜欢接口测试
 */


public class SearchYourLikeTest {
    @BeforeTest
    public void beforeTest(){
        TestConfig.searchYourLikeUrl = ConfigFile.getUrl(InterfaceName.SEARCHYOURLIKE);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(description = "猜你喜欢接口测试")
    public void searchYourLike() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        SearchYourLikeCase searchYourLikeCase = sqlSession.selectOne("searchYourLikeCase",1);
        System.out.println("searchYourLikeCase:" + searchYourLikeCase.toString());
        Integer pageStart = PageInfoUtil.pageTransformation(searchYourLikeCase.getPageSize(),searchYourLikeCase.getPageNum());
        searchYourLikeCase.setPageNum(pageStart);
        System.out.println("pageNum:" + searchYourLikeCase.getPageNum());

        //发送请求，获取接口返回数据
        SearchYourLikeResult result = getResponseResult(searchYourLikeCase);
        System.out.println("猜你喜欢接口返回数据：" + result.toString());
        System.out.println("猜你喜欢接口返回的data数据：" + result.getData().toString());

        //获取实际结果
        //什么样的数据可以定义为是用户喜欢的？？？  recommendFlag =1
        //后面会改成：state=1  attribute=1
        List<JmProject> expectedResult = sqlSession.selectList("searchYourLike",searchYourLikeCase);
        System.out.println("数据库猜你喜欢查询结果：" + expectedResult);
        int expectedTotal = sqlSession.selectOne("searchYourLikeTotal",searchYourLikeCase);
        System.out.println("数据库猜你喜欢总条数：" + expectedTotal);

        //验证结果
        Assert.assertEquals(result.getCode(),0);
        Assert.assertEquals(result.getData().size(),expectedResult.size());
        if (result.getData().isEmpty() || expectedResult.isEmpty()){
            Assert.assertEquals(result.getTotal(),0);
            Assert.assertEquals(result.getTotalPage(),0);
        }else{
            Assert.assertEquals(result.getTotal(),expectedTotal);
            Assert.assertEquals((double) result.getTotalPage(),Math.ceil((float)expectedTotal/Integer.valueOf(searchYourLikeCase.getPageSize())));
            for (int i = 0; i<expectedResult.size(); i++){

                if (result.getData().get(i).isDeleteFlag().equals("false")){
                    result.getData().get(i).setDeleteFlag("0");
                }else if (result.getData().get(i).isDeleteFlag().equals("true")){
                    result.getData().get(i).setDeleteFlag("1");
                }

                Assert.assertEquals(result.getData().get(i).getCreateAt(), DateFormatChange.dateFormatChange(expectedResult.get(i).getCreateAt()));
                Assert.assertEquals(result.getData().get(i).getUpdateAt(),DateFormatChange.dateFormatChange(expectedResult.get(i).getUpdateAt()));
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getModifier(),expectedResult.get(i).getModifier());
                Assert.assertEquals(result.getData().get(i).isDeleteFlag(),String.valueOf(expectedResult.get(i).getDeleteFlag()));
                Assert.assertEquals(result.getData().get(i).getId(),expectedResult.get(i).getId());
                Assert.assertEquals(result.getData().get(i).getCategoryId(),expectedResult.get(i).getCategoryId());
                Assert.assertEquals(result.getData().get(i).getSubCategoryId(),expectedResult.get(i).getSubCategoryId());
                Assert.assertEquals(result.getData().get(i).getCompanyId(),expectedResult.get(i).getCompanyId());
                Assert.assertEquals(result.getData().get(i).getTitle(),expectedResult.get(i).getTitle());
                Assert.assertEquals(result.getData().get(i).getKeyword(),expectedResult.get(i).getKeyword());
                Assert.assertEquals(result.getData().get(i).getPhoto(),expectedResult.get(i).getPhoto());
                Assert.assertEquals(result.getData().get(i).getRecommendFlag(),expectedResult.get(i).getRecommendFlag());
                Assert.assertEquals(result.getData().get(i).getBuildDate(),DateFormatChange.stringDateFormatChange(expectedResult.get(i).getBuildDate()));
                Assert.assertEquals(result.getData().get(i).getOriginAddr(),expectedResult.get(i).getOriginAddr());
                Assert.assertEquals(result.getData().get(i).getBusinessModel(),expectedResult.get(i).getBusinessModel());
                Assert.assertEquals(result.getData().get(i).getProduct(),expectedResult.get(i).getProduct());
                Assert.assertEquals(result.getData().get(i).getCrowd(),expectedResult.get(i).getCrowd());
                Assert.assertEquals(result.getData().get(i).getArea(),expectedResult.get(i).getArea());
                Assert.assertEquals(result.getData().get(i).getSupport(),expectedResult.get(i).getSupport());
                Assert.assertEquals(result.getData().get(i).getInvestMin(),expectedResult.get(i).getInvestMin());
                Assert.assertEquals(result.getData().get(i).getInvestMax(),expectedResult.get(i).getInvestMax());
                Assert.assertEquals(result.getData().get(i).getMargin(),expectedResult.get(i).getMargin());
                Assert.assertEquals(result.getData().get(i).getFacilityCost(),expectedResult.get(i).getFacilityCost());
                Assert.assertEquals(result.getData().get(i).getOtherCost(),Integer.valueOf(expectedResult.get(i).getOtherCost()));
                Assert.assertEquals(result.getData().get(i).getDescription(),expectedResult.get(i).getDescription());
            }
        }



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
