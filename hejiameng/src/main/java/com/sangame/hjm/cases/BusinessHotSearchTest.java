package com.sangame.hjm.cases;

import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.SearchHomeJoinHeadlineResult;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * 查询商机热搜接口测试
 */

public class BusinessHotSearchTest {
    @BeforeTest
    public void beforeTest(){
        TestConfig.businessHotSearchUrl = ConfigFile.getUrl(InterfaceName.BUSINESSHOTSEARCH);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }
    @Test
    public void businessHotSearch() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        //发送请求，获取接口返回结果
        String result = getResponseResult();
        System.out.println("查询商机热搜接口返回的结果：" + result);
    }

    private String getResponseResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.businessHotSearchUrl);
        System.out.println("查询商机热搜Url get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        return result;
    }

}
