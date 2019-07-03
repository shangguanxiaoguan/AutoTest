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

//    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
//    public void beforeTest(){
//        TestConfig.keyWordSearchUrl = ConfigFile.getUrl(InterfaceName.KEYWORDSEARCH);
//        TestConfig.defaultHttpClient = new DefaultHttpClient();
//    }

    @Test(description = "关键字搜索接口测试")
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
        Assert.assertEquals(result.getCode(),0);
        Assert.assertEquals(result.getData().size(),expectedResult.size());
        if (expectedResult.isEmpty() || result.getData().isEmpty()){
            Assert.assertEquals(result.getPageSize(),keyWordSearchCase.getPageSize());
            Assert.assertEquals(result.getPageNum(),0);
            Assert.assertEquals(result.getTotal(),0);
            Assert.assertEquals(result.getTotalPage(),0);
        }else{
            Assert.assertEquals(result.getPageSize(),keyWordSearchCase.getPageSize());
            Assert.assertEquals(result.getPageNum(),0);  //keyWordSearchCase.getPageNum()
            Assert.assertEquals(result.getTotal(),expectedTotal);
//            System.out.println("++++++：" + (float)expectedTotal/keyWordSearchCase.getPageSize());
//            System.out.println("页数：" + Math.ceil((float)expectedTotal/keyWordSearchCase.getPageSize()));
            Assert.assertEquals((double) result.getTotalPage(),Math.ceil((float)expectedTotal/keyWordSearchCase.getPageSize()));
            for (int i = 0; i < expectedResult.size(); i++){

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
//                if (expectedResult.get(i).getRecommendFlag() == null){
//                    expectedResult.get(i).setRecommendFlag(0);
//                }
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
                if (expectedResult.get(i).getOtherCost() == null){
                    Assert.assertEquals(result.getData().get(i).getOtherCost(),expectedResult.get(i).getOtherCost());
                }else{
                    Assert.assertEquals(result.getData().get(i).getOtherCost(),Double.valueOf(expectedResult.get(i).getOtherCost()));
                }
                Assert.assertEquals(result.getData().get(i).getDescription(),expectedResult.get(i).getDescription());
                Assert.assertEquals(result.getData().get(i).getDirectStore(),expectedResult.get(i).getDirectStore());
                Assert.assertEquals(result.getData().get(i).getJoinStore(),expectedResult.get(i).getJoinStore());
                Assert.assertEquals(result.getData().get(i).getMessageNum(),expectedResult.get(i).getMessageNum());
                Assert.assertEquals(result.getData().get(i).getCompanyName(),expectedResult.get(i).getCompanyName());
                Assert.assertEquals(result.getData().get(i).getRegisterTime(),expectedResult.get(i).getRegisterTime());
                Assert.assertEquals(result.getData().get(i).getProjectExtra(),expectedResult.get(i).getProjectExtra());
                Assert.assertEquals(result.getData().get(i).getProjectPhotos(),expectedResult.get(i).getProjectPhotos());
                Assert.assertEquals(result.getData().get(i).getLikes(),expectedResult.get(i).getLikes());
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
