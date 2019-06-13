package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.UpdateUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class UpdateUserInfoTest {

    @Test(dependsOnGroups = "loginTrue",description = "修改用户信息")
    public void updateUserInfo() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase",1);
        System.out.printf(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);

        //发送请求，获取结果
        int result = getResult(updateUserInfoCase);
        Thread.sleep(5000);
        //验证结果
        User user = session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
        System.out.println("updateUserInfo的updateUserInfoCase.getExpected()："+updateUserInfoCase.getExpected());
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);

    }


    @Test(dependsOnGroups = "loginTrue",description = "删除用户信息")
    public void deleteUser() throws IOException, InterruptedException {
        SqlSession session = DatabaseUtil.getSqlSession();
        UpdateUserInfoCase updateUserInfoCase = session.selectOne("updateUserInfoCase",2);
        System.out.printf(updateUserInfoCase.toString());
        System.out.println(TestConfig.updateUserInfoUrl);

        //发送请求，获取结果
        int result = getResult(updateUserInfoCase);
        //验证结果
        Thread.sleep(5000);
        User user = session.selectOne(updateUserInfoCase.getExpected(),updateUserInfoCase);
        Assert.assertNotNull(user);
        Assert.assertNotNull(result);
    }

    private int getResult(UpdateUserInfoCase updateUserInfoCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.updateUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("id",updateUserInfoCase.getUserid());
        param.put("userName",updateUserInfoCase.getUserName());
        param.put("sex",updateUserInfoCase.getSex());
        param.put("age",updateUserInfoCase.getAge());
        param.put("permission",updateUserInfoCase.getPermission());
        param.put("isDelete",updateUserInfoCase.getIsDelete());
        //设置头信息
        post.setHeader("content-type","application/json");

        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);

        //添加cookies
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        //执行post
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String result;
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("更新result:"+ result);
        return Integer.parseInt(result);

    }
}

