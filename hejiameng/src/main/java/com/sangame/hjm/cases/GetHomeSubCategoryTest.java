package com.sangame.hjm.cases;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.GetHomeSubCategoryResult;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmSubCategory;
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
 * 首页主要分类接口测试
 */

public class GetHomeSubCategoryTest {

//    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
//    public void beforeTest(){
//        TestConfig.updateVersionUrl = ConfigFile.getUrl(InterfaceName.UPDATEVERSION);
//        TestConfig.getBannerTurnUrl = ConfigFile.getUrl(InterfaceName.GETBANNERTURN);
//        TestConfig.getHomeSubCategoryUrl = ConfigFile.getUrl(InterfaceName.GETHOMESUBCATEGORY);
//        TestConfig.defaultHttpClient = new DefaultHttpClient();
//    }

    @Test(description = "首页主要分类接口测试")
    public void getHomeSubCategory() throws IOException {

        SqlSession sqlSession = DatebaseUtil.getSqlSession();

        //发送请求，获取接口返回数据
        GetHomeSubCategoryResult result = getJsonResult();
        System.out.println("首页主要分类接口返回数据：" + result.getData().toString());

        //获取数据库实际分类
        //数据是怎么取的？？？ --》取index_flag=1数据
        List<JmSubCategory> actualResult = sqlSession.selectList("getHomeSubCategory");
        System.out.println("首页主要分类数据库数据：" + actualResult.toString());

        //验证结果
        Assert.assertEquals(result.getCode(),0);
        Assert.assertEquals(result.getMsg(),"success");
        for (int i = 0; i <actualResult.size(); i++){
            if (result.getData().get(i).isDeleteFlag().equals("false")){
                result.getData().get(i).setDeleteFlag("0");
            }else if(result.getData().get(i).isDeleteFlag().equals("true")){
                result.getData().get(i).setDeleteFlag("1");
            }

            Assert.assertEquals(result.getData().get(i).getCreateAt(),DateFormatChange.dateFormatChange(actualResult.get(i).getCreated_at()));
            Assert.assertEquals(result.getData().get(i).getUpdateAt(),DateFormatChange.dateFormatChange(actualResult.get(i).getUpdated_at()));
            Assert.assertEquals(result.getData().get(i).getCreator(),actualResult.get(i).getCreator());
            Assert.assertEquals(result.getData().get(i).getModifier(),actualResult.get(i).getModifier());
            Assert.assertEquals(result.getData().get(i).isDeleteFlag(),String.valueOf(actualResult.get(i).getDelete_flag()));
            Assert.assertEquals(result.getData().get(i).getId(),actualResult.get(i).getId());
            Assert.assertEquals(result.getData().get(i).getCategoryId(),actualResult.get(i).getCategory_id());
            Assert.assertEquals(result.getData().get(i).getTitle(),actualResult.get(i).getTitle());
            Assert.assertEquals(result.getData().get(i).getSpell(),actualResult.get(i).getSpell());
            Assert.assertEquals(result.getData().get(i).getIcon(),actualResult.get(i).getIcon());
            Assert.assertEquals(result.getData().get(i).getHotFlag(),actualResult.get(i).getHot_flag());
            Assert.assertEquals(result.getData().get(i).getRecommendFlag(),actualResult.get(i).getRecommend_flag());
            Assert.assertEquals(result.getData().get(i).getIndexFlag(),Integer.valueOf(actualResult.get(i).getIndex_flag()));
        }


    }

    private GetHomeSubCategoryResult getJsonResult() throws IOException {

        HttpGet get = new HttpGet(TestConfig.getHomeSubCategoryUrl);
        System.out.println("首页主要分类Url get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        GetHomeSubCategoryResult resultClass = new Gson().fromJson(result,GetHomeSubCategoryResult.class);
        return resultClass;
    }
}
