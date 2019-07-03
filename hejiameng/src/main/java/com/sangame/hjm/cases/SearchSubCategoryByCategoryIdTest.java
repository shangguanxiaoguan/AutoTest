package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmSubCategory;
import com.sangame.hjm.model.SearchSubCategoryByCategoryIdCase;
import com.sangame.hjm.model.SearchSubCategoryByCategoryIdResult;
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
 * 根据行业id查询分类接口测试
 */


public class SearchSubCategoryByCategoryIdTest {

    @BeforeTest
    public void beforeTest(){
        TestConfig.searchSubCategoryByCategoryIdUrl = ConfigFile.getUrl(InterfaceName.SEARCHSUBCATEGORYBYCATEGORYID);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(description = "根据行业id查询分类接口测试")
    public void SearchSubCategoryByCategoryId() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        SearchSubCategoryByCategoryIdCase searchSubCategoryByCategoryIdCase = sqlSession.selectOne("searchSubCategoryByCategoryIdCase",1);

        //发送请求，获取接口返回的结果
        SearchSubCategoryByCategoryIdResult result = getResponseResult(searchSubCategoryByCategoryIdCase);
        System.out.println("根据行业查询分类接口返回的数据：" + result.toString());
        System.out.println("根据行业查询分类接口返回的data数据：" + result.getData().toString());

        //获取数据库数据   searchSubCategoryByCategoryIdCase.getExpected()
        List<JmSubCategory> expectedResult = sqlSession.selectList("searchSubCategoryByCategoryId",searchSubCategoryByCategoryIdCase);
        System.out.println("数据库返回的结果：" + expectedResult.toString());

        //验证结果
        Assert.assertEquals(result.getCode(),0);
        Assert.assertEquals(result.getData().size(),expectedResult.size());
        if (!result.getData().isEmpty() && !expectedResult.isEmpty()){
            for (int i = 0; i<expectedResult.size();i++){
                if (result.getData().get(i).isDeleteFlag().equals("false")){
                    result.getData().get(i).setDeleteFlag("0");
                }else if (result.getData().get(i).isDeleteFlag().equals("true")){
                    result.getData().get(i).setDeleteFlag("1");
                }
                Assert.assertEquals(result.getData().get(i).getCreateAt(), DateFormatChange.dateFormatChange(expectedResult.get(i).getCreated_at()));
                Assert.assertEquals(result.getData().get(i).getUpdateAt(), DateFormatChange.dateFormatChange(expectedResult.get(i).getUpdated_at()));
                Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
                Assert.assertEquals(result.getData().get(i).getModifier(),expectedResult.get(i).getModifier());
                Assert.assertEquals(result.getData().get(i).isDeleteFlag(),String.valueOf(expectedResult.get(i).getDelete_flag()));
                Assert.assertEquals(result.getData().get(i).getId(),expectedResult.get(i).getId());
                Assert.assertEquals(result.getData().get(i).getCategoryId(),expectedResult.get(i).getCategory_id());
                Assert.assertEquals(result.getData().get(i).getTitle(),expectedResult.get(i).getTitle());
                Assert.assertEquals(result.getData().get(i).getSpell(),expectedResult.get(i).getSpell());
                Assert.assertEquals(result.getData().get(i).getIcon(),expectedResult.get(i).getIcon());
                Assert.assertEquals(result.getData().get(i).getHotFlag(),expectedResult.get(i).getHot_flag());
                Assert.assertEquals(result.getData().get(i).getRecommendFlag(),expectedResult.get(i).getRecommend_flag());
                if (expectedResult.get(i).getIndex_flag()== null){
                    Assert.assertEquals(result.getData().get(i).getIndexFlag(),null);
                }else{
                    Assert.assertEquals(result.getData().get(i).getIndexFlag(),Double.valueOf(expectedResult.get(i).getIndex_flag()));
                }

            }
        }

    }

    private SearchSubCategoryByCategoryIdResult getResponseResult(SearchSubCategoryByCategoryIdCase searchSubCategoryByCategoryIdCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.searchSubCategoryByCategoryIdUrl + "?id=" + searchSubCategoryByCategoryIdCase.getCategoryId());
        System.out.println("searchSubCategoryByCategoryIdUrl get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        SearchSubCategoryByCategoryIdResult resultClass = new Gson().fromJson(result,SearchSubCategoryByCategoryIdResult.class);
        return resultClass;
    }
}
