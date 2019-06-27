package com.sangame.hjm.cases;


import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.JmNeed;
import com.sangame.hjm.model.ProjectCustomCase;
import com.sangame.hjm.model.ProjectCustomResult;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * 项目定制接口测试
 */

public class ProjectCustomTest {

    @Test
    public void projectCustom() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        ProjectCustomCase projectCustomCase = sqlSession.selectOne("projectCustomCase",1);

        //发送请求，获取接口返回数据
        ProjectCustomResult result = getResponseResult(projectCustomCase);

        //验证结果
        JmNeed actualResult = sqlSession.selectOne(projectCustomCase.getExpect(),projectCustomCase);

        Assert.assertEquals("0",result.getCode());
        Assert.assertEquals("success",result.getMsg());
        Assert.assertNotNull(actualResult);
    }

    private ProjectCustomResult getResponseResult(ProjectCustomCase projectCustomCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.projectCustomUrl);
        JSONObject param = new JSONObject();
        param.put("cngoldId",projectCustomCase.getCngoldId());
        param.put("gender",projectCustomCase.getGender());
        param.put("leavingMessage",projectCustomCase.getLeavingMessage());
        param.put("name",projectCustomCase.getName());
        param.put("amountCode",projectCustomCase.getAmountCode());
        param.put("amountValue",projectCustomCase.getAmountValue());
        param.put("interestCategory",projectCustomCase.getInterestCategory());
        param.put("phoneNumber",projectCustomCase.getPhoneNumber());
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        System.out.println("projectCustomUrl post：" + post);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        ProjectCustomResult resultClass = new Gson().fromJson(result,ProjectCustomResult.class);
        return resultClass;
    }
}
