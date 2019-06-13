package com.course.cases;

import com.alibaba.fastjson.TypeReference;
import com.course.config.TestConfig;
import com.course.model.GetUserInfoCase;
import com.course.model.GetUserListCase;
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

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GetUserListTest {
    @Test(dependsOnGroups = "loginTrue",description = "获取性别为男的用户信息")
    public void getUserList() throws IOException {
        SqlSession session = DatabaseUtil.getSqlSession();
        GetUserListCase getUserListCase = session.selectOne("getUserListCase",1);
        System.out.printf(getUserListCase.toString());
        System.out.println(TestConfig.getUserListUrl);

        //发送请求获取结果
//        JSONArray resultJson = getJsonResult(getUserListCase);
        List<User> resultJson = getJsonResult(getUserListCase);

        //验证
        List<User> userList = session.selectList(getUserListCase.getExpected(),getUserListCase);
//        for (User u:userList){
//            System.out.println("获取的user："+u.toString());
//        }
        System.out.println("userList:"+userList.toString());
        JSONArray userListJson = new JSONArray(userList);
        System.out.println("userListJson:"+userListJson.toString());
        System.out.println("实际结果resultJson："+resultJson.toString());
        //先比较预期结果的长度和实际结果的长度是否相同
        Assert.assertEquals(userListJson.length(),resultJson.size());

        //再比较每个值是否相同
        for (int i = 0;i<resultJson.size();i++){
//            JSONObject expect = (JSONObject) resultJson.get(i);
            User expect = resultJson.get(i);
            JSONObject actual = (JSONObject) userListJson.get(i);
            Assert.assertEquals(expect.toString(),actual.toString());
        }
    }

    private List<User> getJsonResult(GetUserListCase getUserListCase) throws IOException {
        HttpPost post = new HttpPost(TestConfig.getUserListUrl);
        JSONObject param = new JSONObject();
        param.put("userName",getUserListCase.getUserName());
        param.put("sex",getUserListCase.getSex());
        param.put("age",getUserListCase.getAge());
        //设置头信息
        post.setHeader("content-type","application/json");
        //把结果添加到post方法中
        StringEntity entity = new StringEntity(param.toString(),"utf-8");
        post.setEntity(entity);
        TestConfig.defaultHttpClient.setCookieStore(TestConfig.store);
        String result;
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println("result:"+result);

        // Json 转List
        List<User> userList = JSON.parseObject(result,new TypeReference<List<User>>(){});



//        List resultList = Arrays.asList(result);
//        System.out.println("resultList:"+resultList);
////        JSONArray resultArray = new JSONArray(resultList);
//        JSONObject resultJson = new JSONObject(resultList);
//        JSONArray resultArray = new JSONArray(resultJson);
////        System.out.println("resultList:"+resultList);
//        System.out.println("resultArray:"+resultArray.toString());
        return userList;
    }
}
