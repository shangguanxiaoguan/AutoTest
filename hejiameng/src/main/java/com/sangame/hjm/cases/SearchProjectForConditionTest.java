package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmProject;
import com.sangame.hjm.model.SearchProjectForConditionCase;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class SearchProjectForConditionTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.searchProjectForConditionUrl = ConfigFile.getUrl(InterfaceName.SEARCHPROJECTFORCONDITION);
    }

    @Test
    public void searchProjectForCondition() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        SearchProjectForConditionCase searchProjectForConditionCase = sqlSession.selectOne("searchProjectForConditionCase",1);
        System.out.println("SearchProjectForConditionCase:" + searchProjectForConditionCase.toString());
        //发送请求，获取接口返回数据
        SearchProjectForConditionCase result = getResponseResult(searchProjectForConditionCase);

        //验证结果
        List<JmProject> projectList = sqlSession.selectList(searchProjectForConditionCase.getExpect(),searchProjectForConditionCase);



    }

    private SearchProjectForConditionCase getResponseResult(SearchProjectForConditionCase searchProjectForConditionCase) throws IOException {
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
        SearchProjectForConditionCase resultJson = new Gson().fromJson(result,SearchProjectForConditionCase.class);
        return resultJson;
    }
}
