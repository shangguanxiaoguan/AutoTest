package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmProject;
import com.sangame.hjm.model.SearchProjectForConditionCase;
import com.sangame.hjm.model.SearchProjectForConditionResult;
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
import java.lang.reflect.Field;
import java.util.List;

/**
 * 根据条件查询品牌接口测试
 */


public class SearchProjectForConditionTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.searchProjectForConditionUrl = ConfigFile.getUrl(InterfaceName.SEARCHPROJECTFORCONDITION);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(description = "根据条件查询品牌接口测试")
    public void searchProjectForCondition() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        SearchProjectForConditionCase searchProjectForConditionCase = sqlSession.selectOne("searchProjectForConditionCase",2);
        System.out.println("SearchProjectForConditionCase:" + searchProjectForConditionCase.toString());
        //发送请求，获取接口返回数据
        SearchProjectForConditionResult result = getResponseResult(searchProjectForConditionCase);
        System.out.println("根据条件查询品牌接口返回的数据：" + result.toString());
        System.out.println("根据条件查询品牌接口返回的data数据：" + result.getData().toString());

        //获取数据库数据
        List<JmProject> expectedResult = sqlSession.selectList(searchProjectForConditionCase.getExpect(),searchProjectForConditionCase);
        System.out.println("数据库根据条件查询品牌查询出的结果：" + expectedResult);
        int expectTotal = sqlSession.selectOne("searchJmProjectForConditionTotal",searchProjectForConditionCase);
        System.out.println("数据库根据条件查询品牌总条数：" + expectTotal);

        //验证结果
        Assert.assertEquals(result.getCode(),0);
        Assert.assertEquals(result.getData().size(),expectedResult.size());
        if (result.getData().isEmpty() || expectedResult.isEmpty()){
            Assert.assertEquals(String.valueOf(result.getPageSize()),searchProjectForConditionCase.getPageSize());
            Assert.assertEquals(result.getPageNum(),0);
            Assert.assertEquals(result.getTotal(),0);
            Assert.assertEquals(result.getTotalPage(),0);
        }else{
            Assert.assertEquals(String.valueOf(result.getPageSize()),searchProjectForConditionCase.getPageSize());
            Assert.assertEquals(result.getPageNum(),searchProjectForConditionCase.getPageNum());
            Assert.assertEquals(result.getTotal(),expectTotal);
            Assert.assertEquals((double) result.getTotalPage(),Math.ceil((float)expectTotal/Integer.valueOf(searchProjectForConditionCase.getPageSize())));
            for (int i = 0; i < expectedResult.size(); i++){
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
                Assert.assertEquals(result.getData().get(i).getOtherCost(),expectedResult.get(i).getOtherCost());
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

    private SearchProjectForConditionResult getResponseResult(SearchProjectForConditionCase searchProjectForConditionCase) throws IOException {
//        searchProjectForConditionCase = new SearchProjectForConditionCase();
        //获取对象类里面的字段
//        Field[] fields = searchProjectForConditionCase.getClass().getDeclaredFields();

        HttpGet get =new HttpGet(TestConfig.searchProjectForConditionUrl + "?title=" + searchProjectForConditionCase.getTitle()
                + "&amountCode=" + searchProjectForConditionCase.getAmountCode()
                + "&sortCode=" + searchProjectForConditionCase.getSortCode()
                + "&subCategoryId=" + searchProjectForConditionCase.getSubCategoryId()
                + "&pageSize=" + searchProjectForConditionCase.getPageSize()
                + "&pageNum=" + searchProjectForConditionCase.getPageNum());
        System.out.println("searchProjectForCondition get:" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        SearchProjectForConditionResult resultClass = new Gson().fromJson(result,SearchProjectForConditionResult.class);
        return resultClass;
    }
}
