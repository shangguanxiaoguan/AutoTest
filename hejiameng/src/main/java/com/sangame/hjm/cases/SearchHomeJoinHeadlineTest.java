package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmProject;
import com.sangame.hjm.model.SearchHomeJoinHeadlineResult;
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
 * 查询首页加盟头条接口测试
 */


public class SearchHomeJoinHeadlineTest {
//    @BeforeTest
//    public void beforeTest(){
//        TestConfig.searchHomeJoinHeadlineUrl = ConfigFile.getUrl(InterfaceName.GETHOMEJOINHEADLINE);
//        TestConfig.defaultHttpClient = new DefaultHttpClient();
//    }
    @Test(description = "查询首页加盟头条接口测试")
    public void searchHomeJoinHeadline() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();

        //发送请求，获取接口返回结果
        SearchHomeJoinHeadlineResult result = getResponseResult();
        System.out.println("查询首页加盟头条接口返回的结果：" + result.toString());
        System.out.println("查询首页加盟头条接口返回的data结果：" + result.getData().toString());

        //获取数据库数据
        List<JmProject> expectedResult =sqlSession.selectList("getHomeJoinHeadline");
        System.out.println("数据库查询的结果：" + expectedResult.toString());

        //验证结果
        Assert.assertEquals(result.getCode(),0);
        Assert.assertEquals(result.getData().size(),expectedResult.size());
        if (!result.getData().isEmpty() && !expectedResult.isEmpty()){
            for (int i = 0;i < expectedResult.size(); i++){
                if (result.getData().get(i).isDeleteFlag().equals("false")){
                    result.getData().get(i).setDeleteFlag("0");
                }else if (result.getData().get(i).isDeleteFlag().equals("true")){
                    result.getData().get(i).setDeleteFlag("1");
                }

                Assert.assertEquals(result.getData().get(i).getCreateAt(), DateFormatChange.dateFormatChange(expectedResult.get(i).getCreateAt()));
                Assert.assertEquals(result.getData().get(i).getUpdateAt(), DateFormatChange.dateFormatChange(expectedResult.get(i).getUpdateAt()));
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
//                if (expectedResult.get(i).getOtherCost() == null){
//                    Assert.assertEquals(result.getData().get(i).getOtherCost(),expectedResult.get(i).getOtherCost());
//                }
                Assert.assertEquals(result.getData().get(i).getOtherCost(),expectedResult.get(i).getOtherCost());
                Assert.assertEquals(result.getData().get(i).getDescription(),expectedResult.get(i).getDescription());
                Assert.assertEquals(result.getData().get(i).getCompanyName(),expectedResult.get(i).getCompanyName());
                Assert.assertEquals(result.getData().get(i).getRegisterTime(),expectedResult.get(i).getRegisterTime());
                Assert.assertEquals(result.getData().get(i).getState(),expectedResult.get(i).getState());
                Assert.assertEquals(result.getData().get(i).getStateName(),"上架中");
                Assert.assertEquals(result.getData().get(i).getAttribute(),expectedResult.get(i).getAttribute());
                Assert.assertEquals(result.getData().get(i).getAttributeName(),"头条");
                Assert.assertEquals(result.getData().get(i).getProjectExtra(),expectedResult.get(i).getProjectExtra());
                Assert.assertEquals(result.getData().get(i).getProjectPhotos(),expectedResult.get(i).getProjectPhotos());
                Assert.assertEquals(result.getData().get(i).getLikes(),expectedResult.get(i).getLikes());

            }
        }

    }


    private SearchHomeJoinHeadlineResult getResponseResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.searchHomeJoinHeadlineUrl);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        SearchHomeJoinHeadlineResult resultClass = new Gson().fromJson(result,SearchHomeJoinHeadlineResult.class);
        return resultClass;
    }
}
