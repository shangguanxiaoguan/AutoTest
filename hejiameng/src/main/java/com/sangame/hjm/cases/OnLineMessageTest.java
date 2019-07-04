package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmComment;
import com.sangame.hjm.model.OnLineMessageCase;
import com.sangame.hjm.model.OnLineMessageResult;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import static com.sangame.hjm.utils.HttpMethodPostUtil.httpMethodPost;

/**
 * 在线留言接口测试
 */


public class OnLineMessageTest {

    @BeforeTest
    public void beforeTest(){
        TestConfig.onLineMessageUrl = ConfigFile.getUrl(InterfaceName.ONLINEMESSAGE);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(description = "在线留言接口测试")
    public void onLineMessage() throws IOException, InterruptedException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        OnLineMessageCase onLineMessageCase = sqlSession.selectOne("onLineMessageCase","1"); //先取第一条数据

        Map<String,Object> map=new HashMap<>();
        map.put("commentId",onLineMessageCase.getCommentId());
        map.put("cngoldId",onLineMessageCase.getCngoldId());
        map.put("content",onLineMessageCase.getContent());
        String result=httpMethodPost(TestConfig.onLineMessageUrl,map);
        OnLineMessageResult onLineMessageResult = new Gson().fromJson(result,OnLineMessageResult.class);
        System.out.println("在线留言接口返回的数据：" + onLineMessageResult.toString());

        //获取在线留言后的数据
        SqlSession expectedSession = DatebaseUtil.getSqlSession();
        JmComment expectedResult = expectedSession.selectOne("getOnLineMessage",onLineMessageCase);
        if (expectedResult != null){
            System.out.println("获取在线留言后的数据：" + expectedResult.toString());
            //验证结果
            Assert.assertEquals(onLineMessageResult.getCode(),0);
            Assert.assertEquals(onLineMessageResult.getMsg(),"success");
            Assert.assertNotNull(expectedResult);

        }

    }

}
