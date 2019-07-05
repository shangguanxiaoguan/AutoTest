package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.SearchInvestmentResult;
import com.sangame.hjm.utils.ConfigFile;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class SearchInvestmentTest {
    @BeforeTest
    public void beforeTest(){
        TestConfig.searchInvestmentUrl = ConfigFile.getUrl(InterfaceName.SEARCHINVESTMENT);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test
    public void searchInvestment() throws IOException {
        SearchInvestmentResult result = getResponseResult();
        System.out.println("查询投资预算接口返回的结果：" + result.toString());

        //验证结果
        Assert.assertEquals(result.getCode(),0);
        Assert.assertNotNull(result.getData());
//        for (int i = 0; i<result.getData().size();i++){
//            if (result.getData().get(i).getCode() == 0){
//
//            }
//        }
    }

    private SearchInvestmentResult getResponseResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.searchInvestmentUrl);
        System.out.println("查询投资预算Url get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        SearchInvestmentResult resultClass = new Gson().fromJson(result,SearchInvestmentResult.class);
        return resultClass;
    }
}
