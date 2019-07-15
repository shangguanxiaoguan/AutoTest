package com.sangame.hjm.cases;


import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmNeed;
import com.sangame.hjm.model.ProjectCustomCase;
import com.sangame.hjm.model.ProjectCustomResult;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import com.sangame.hjm.utils.HttpMethodPostUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 项目定制接口测试
 */

public class ProjectCustomTest {

    @BeforeTest
    public void beforeTest(){
        TestConfig.projectCustomUrl = ConfigFile.getUrl(InterfaceName.PROJECTCUSTOM);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(description = "项目定制接口测试")
    public void projectCustom() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        ProjectCustomCase projectCustomCase = sqlSession.selectOne("projectCustomCase",1);
        System.out.println("projectCustomCase:" + projectCustomCase.toString());

        //发送请求，获取接口返回数据
//        try {
            Map<String,Object> map = new HashMap<>();
            map.put("cngoldId",projectCustomCase.getCngoldId());
            map.put("gender",projectCustomCase.getGender());
            map.put("leavingMessage",projectCustomCase.getLeavingMessage());
            map.put("name",projectCustomCase.getName());
            map.put("investCode",projectCustomCase.getInvestCode());
            map.put("investValue",projectCustomCase.getInvestValue());
            map.put("interestCategory",projectCustomCase.getInterestCategory());
            map.put("phoneNumber",projectCustomCase.getPhoneNumber());
            map.put("projectId",projectCustomCase.getProjectId());
        System.out.println("map"+map.toString());
            String result = HttpMethodPostUtil.httpMethodPost(TestConfig.projectCustomUrl,map);
            ProjectCustomResult projectCustomResult = new Gson().fromJson(result,ProjectCustomResult.class);
            System.out.println("项目定制接口返回的结果：" + projectCustomResult.toString());

            //验证结果
            SqlSession sqlSession1=DatebaseUtil.getSqlSession();
            JmNeed expectedResult = sqlSession1.selectOne("getProjectCustom",projectCustomCase);
            System.out.println("数据库查询出的结果：" + expectedResult.toString());

//            Assert.assertEquals(projectCustomResult.getCode(),0);
//            Assert.assertEquals(projectCustomResult.getMsg(),"success");
            Assert.assertNotNull(expectedResult);


    }

}
