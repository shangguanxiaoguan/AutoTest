package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmCategory;
import com.sangame.hjm.model.SearchCategoryResult;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
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

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.searchCategoryUrl = ConfigFile.getUrl(InterfaceName.SEARCHCATEGORY);
    }

    @Test
    public void searchCategory() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();

        //发送请求，获取接口返回数据
        SearchCategoryResult result = getResponseResult();

        //验证结果
        List<JmCategory> actualData = sqlSession.selectList("searchCategory");
        //先比较两者的数据长度是不是一样的
        Assert.assertEquals(actualData.size(),result.getData().size());
        //再逐个字段比较
        for (int i = 0; i <actualData.size(); i++){
            Assert.assertEquals(actualData.get(i).getCreateAt(),result.getData().get(i).getCreateAt());
            Assert.assertEquals(actualData.get(i).getUpdateAt(),result.getData().get(i).getUpdateAt());
            Assert.assertEquals(actualData.get(i).getCreator(),result.getData().get(i).getCreator());
            Assert.assertEquals(actualData.get(i).getModifier(),result.getData().get(i).getModifier());
            Assert.assertEquals(actualData.get(i).isDeleteFlag(),result.getData().get(i).isDeleteFlag());
            Assert.assertEquals(actualData.get(i).getId(),result.getData().get(i).getId());
            Assert.assertEquals(actualData.get(i).getSpell(),result.getData().get(i).getSpell());
            Assert.assertEquals(actualData.get(i).getTitle(),result.getData().get(i).getTitle());
            Assert.assertEquals(actualData.get(i).getIcon(),result.getData().get(i).getIcon());
        }
    }

    private SearchCategoryResult getResponseResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.searchCategoryUrl);
        System.out.println("searchCategoryUrl get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        SearchCategoryResult resultClass = new Gson().fromJson(result,SearchCategoryResult.class);
        return resultClass;
    }

}
