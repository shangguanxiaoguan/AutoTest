package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.model.User;
import com.course.utils.DatabaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetUserInfoTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取userId为1的用户信息")
    public void getUserInfo() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserInfoCase getUserInfoCase = session.selectOne("getUserInfoCase",1);
        System.out.printf(getUserInfoCase.toString());
        System.out.println(TestConfig.getUserInfoUrl);
        //发送请求，获取结果
        JSONArray resultJson = getJsonResult(getUserInfoCase);

        User user = session.selectOne(getUserInfoCase.getExpected(),getUserInfoCase);
        //User对象转换成JsonArray的前提必须先转换成列表
        List userList = new ArrayList();
        userList.add(user);
        JSONArray jsonArray = new JSONArray(userList);
        //通过断点可看出，resultJson是两层数组，也就是resultJson[0]的内容和user是相同的，
        //所有取resultJson的第一个元素
        JSONArray jsonArray1 = new JSONArray(resultJson.getString(0));

        //返回的结果只有一个，直接对比
        Assert.assertEquals(jsonArray.toString(),jsonArray1.toString());//返回的数据顺序不一样。解决办法：把字段一个一个取出来作对比


    }

    private JSONArray getJsonResult(GetUserInfoCase getUserInfoCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserInfoUrl);
        JSONObject param = new JSONObject();
        param.put("id",getUserInfoCase.getUserid());
        post.setHeader("content-type","application/json");
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        System.out.println("entity:" + entity);
        post.setEntity(entity);

        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        List resultList = Arrays.asList(result);
        JSONArray resultArray = new JSONArray(resultList);
        return resultArray;
    }


}
