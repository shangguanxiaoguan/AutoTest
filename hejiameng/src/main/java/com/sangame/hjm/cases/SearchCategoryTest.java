package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmCategory;
import com.sangame.hjm.model.SearchCategoryResult;
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
 * 查询分类接口测试
 */

public class SearchCategoryTest {

//    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
//    public void beforeTest(){
//        TestConfig.searchCategoryUrl = ConfigFile.getUrl(InterfaceName.SEARCHCATEGORY);
//        TestConfig.defaultHttpClient = new DefaultHttpClient();
//    }

    @Test(description = "查询分类接口")
    public void searchCategory() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();

        //发送请求，获取接口返回数据
        SearchCategoryResult result = getResponseResult();
        System.out.println("查询分类接口返回的结果：" + result.toString());
        System.out.println("查询分类接口返回的data结果：" + result.getData().toString());

        //查询数据库分类结果
        List<JmCategory> expectedResult = sqlSession.selectList("searchCategory");
        System.out.println("数据库查询分类结果：" + expectedResult);

        //验证结果
        //先比较两者的数据长度是不是一样的
        Assert.assertEquals(result.getData().size(),expectedResult.size());
        //再逐个字段比较
        for (int i = 0; i <expectedResult.size(); i++){
            Assert.assertEquals(result.getData().get(i).getCreateAt(), DateFormatChange.dateFormatChange(expectedResult.get(i).getCreateAt()));
            Assert.assertEquals(result.getData().get(i).getUpdateAt(),DateFormatChange.dateFormatChange(expectedResult.get(i).getUpdateAt()));
            Assert.assertEquals(result.getData().get(i).getCreator(),expectedResult.get(i).getCreator());
            Assert.assertEquals(result.getData().get(i).getModifier(),expectedResult.get(i).getModifier());
            Assert.assertEquals(result.getData().get(i).isDeleteFlag(),expectedResult.get(i).isDeleteFlag());
            Assert.assertEquals(result.getData().get(i).getId(),expectedResult.get(i).getId());
            Assert.assertEquals(result.getData().get(i).getSpell(),expectedResult.get(i).getSpell());
            Assert.assertEquals(result.getData().get(i).getTitle(),expectedResult.get(i).getTitle());
            Assert.assertEquals(result.getData().get(i).getIcon(),expectedResult.get(i).getIcon());
        }
    }

    private SearchCategoryResult getResponseResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.searchCategoryUrl);
        System.out.println("searchCategoryUrl get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("查询分类result：" + result);
        SearchCategoryResult resultClass = new Gson().fromJson(result,SearchCategoryResult.class);
        return resultClass;
    }

}
