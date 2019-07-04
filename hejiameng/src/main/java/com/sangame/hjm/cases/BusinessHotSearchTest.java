package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.*;
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
 * 查询商机热搜接口测试
 */

public class BusinessHotSearchTest {
    @BeforeTest
    public void beforeTest(){
        TestConfig.businessHotSearchUrl = ConfigFile.getUrl(InterfaceName.BUSINESSHOTSEARCH);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }
    @Test
    public void businessHotSearch() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        //发送请求，获取接口返回结果
        BusinessHotSearchResult result = getResponseResult();
        System.out.println("查询商机热搜接口返回的结果：" + result.toString());
        System.out.println("查询商机热搜接口返回的data结果：" + result.getData().toString());

        //获取数据库数据
        List<BusinessHotSearch> expectedResult = sqlSession.selectList("getBusinessHotSearch");
        System.out.println("数据库结果：" + expectedResult.toString());

        //验证结果
        Assert.assertEquals(result.getCode(),0);
        Assert.assertEquals(result.getData().size(),expectedResult.size());
        for (int i = 0; i<expectedResult.size(); i++){
            Assert.assertEquals(result.getData().get(i).getCreateAt(), DateFormatChange.dateFormatChange(expectedResult.get(i).getCreateAt()));
            Assert.assertEquals(result.getData().get(i).getUpdateAt(),DateFormatChange.dateFormatChange(expectedResult.get(i).getUpdateAt()));
            Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
            Assert.assertEquals(result.getData().get(i).getModifier(),expectedResult.get(i).getModifier());
            if (expectedResult.get(i).getDeleteFlag() == 0){
                Assert.assertEquals(result.getData().get(i).isDeleteFlag(),false);
            }else{
                Assert.assertEquals(result.getData().get(i).isDeleteFlag(),true);
            }
            Assert.assertEquals(result.getData().get(i).getId(),expectedResult.get(i).getId());
            Assert.assertEquals(result.getData().get(i).getCategoryId(),expectedResult.get(i).getCategoryId());
            Assert.assertEquals(result.getData().get(i).getSubCategoryId(),expectedResult.get(i).getSubCategoryId());
            Assert.assertEquals(result.getData().get(i).getCompanyId(),expectedResult.get(i).getCompanyId());
            Assert.assertEquals(result.getData().get(i).getTitle(),expectedResult.get(i).getTitle());
            Assert.assertEquals(result.getData().get(i).getKeyword(),expectedResult.get(i).getKeyword());
            Assert.assertEquals(result.getData().get(i).getPhoto(),expectedResult.get(i).getPhoto());
            Assert.assertEquals(result.getData().get(i).getRecommendFlag(),expectedResult.get(i).getRecommendFlag());
            Assert.assertEquals(result.getData().get(i).getBuildDate(), DateFormatChange.stringDateFormatChange(expectedResult.get(i).getBuildDate()));
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
            Assert.assertEquals(result.getData().get(i).getCompanyName(),expectedResult.get(i).getCompanyName());
            if (expectedResult.get(i).getRegisterTime() == null || expectedResult.get(i).getRegisterTime() == 0 ){
                Assert.assertEquals(result.getData().get(i).getRegisterTime(),null);
            }else{
                Assert.assertEquals(result.getData().get(i).getRegisterTime(),expectedResult.get(i).getRegisterTime());
            }
            Assert.assertEquals(result.getData().get(i).getState(),expectedResult.get(i).getState());
            if (result.getData().get(i).getState() == 0){
                Assert.assertEquals(result.getData().get(i).getStateName(),"待上架");
            }else if (result.getData().get(i).getState() == 1){
                Assert.assertEquals(result.getData().get(i).getStateName(),"上架中");
            }else if (result.getData().get(i).getState() == 2){
                Assert.assertEquals(result.getData().get(i).getStateName(),"已下线");
            }
            Assert.assertEquals(result.getData().get(i).getAttribute(),expectedResult.get(i).getAttribute());
            if (expectedResult.get(i).getAttribute() == 0){
                Assert.assertEquals(result.getData().get(i).getAttributeName(),"推荐");
            }else if(expectedResult.get(i).getAttribute() == 1){
                Assert.assertEquals(result.getData().get(i).getAttributeName(),"头条");
            }
            Assert.assertEquals(result.getData().get(i).getApplyCount(),expectedResult.get(i).getApply_count());
            Assert.assertEquals(result.getData().get(i).getVisitCount(),expectedResult.get(i).getVisit_count());
            Assert.assertEquals(result.getData().get(i).getInvestCode(),expectedResult.get(i).getInvestCode());
            Assert.assertEquals(result.getData().get(i).getInvestValue(),expectedResult.get(i).getInvestValue());
            Assert.assertEquals(result.getData().get(i).getRegionId(),expectedResult.get(i).getRegionId());


        }





    }

    private BusinessHotSearchResult getResponseResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.businessHotSearchUrl);
        System.out.println("查询商机热搜Url get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        BusinessHotSearchResult resultClass = new Gson().fromJson(result,BusinessHotSearchResult.class);
        return resultClass;
    }

}
