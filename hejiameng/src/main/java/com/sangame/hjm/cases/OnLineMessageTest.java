package com.sangame.hjm.cases;


import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.JmComment;
import com.sangame.hjm.model.OnLineMessageCase;
import com.sangame.hjm.model.OnLineMessageResult;
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
 * 在线留言接口测试
 */


public class OnLineMessageTest {

    @Test
    public void onLineMessage() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        OnLineMessageCase onLineMessageCase = sqlSession.selectOne("onLineMessageCase","1"); //先取第一条数据

        //发送请求，获取接口返回数据
        OnLineMessageResult result = getResponseResult(onLineMessageCase);

        //验证结果
        JmComment actualResult = sqlSession.selectOne(onLineMessageCase.getExpect(),onLineMessageCase);
        Assert.assertEquals("0",result.getCode());
        Assert.assertEquals("success",result.getMsg());
        Assert.assertNotNull(actualResult);

    }

    private OnLineMessageResult getResponseResult(OnLineMessageCase onLineMessageCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.onLineMessageUrl);
        JSONObject param = new JSONObject();
        param.put("commentId",onLineMessageCase.getCommentId());
        param.put("content",onLineMessageCase.getContent());
        param.put("cngoldId",onLineMessageCase.getCngoldId());
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        System.out.println("onLineMessageUrl post:" + post);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result = EntityUtils.toString(response.getEntity());
        OnLineMessageResult resultClass = new Gson().fromJson(result,OnLineMessageResult.class);
        return resultClass;
    }
}
