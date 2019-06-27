package com.sangame.hjm.cases;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.Banner;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;


/**
 * 首页轮播图接口测试
 */

public class GetBannerTurnTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.updateVersionUrl = ConfigFile.getUrl(InterfaceName.UPDATEVERSION);
        TestConfig.getBannerTurnUrl = ConfigFile.getUrl(InterfaceName.GETBANNERTURN);
        TestConfig.getHomeSubCategoryUrl = ConfigFile.getUrl(InterfaceName.GETHOMESUBCATEGORY);
    }

    @Test
    public void getBannerTurn() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        //发送请求，获取接口返回结果
        JSONObject resultJson = getJsonResult();

        //获取数据库存储的banner信息
        List<Banner> bannerList = sqlSession.selectList("getBannerTurn");
        System.out.println("bannerList:"+ bannerList.toString());

        //验证结果
        JSONArray resultList = resultJson.getJSONArray("data");
        //先比较预期结果的长度和实际结果的长度
        Assert.assertEquals(bannerList.size(),resultList.size());
        JSONObject resultListData = null;
        for (int i = 0; i < resultList.size(); i++){
            resultListData = resultList.getJSONObject(i);
            Assert.assertEquals(bannerList.get(i).getCreated_at(),resultListData.getString("createAt"));
            Assert.assertEquals(bannerList.get(i).getUpdated_at(),resultListData.getString("updateAt"));
            Assert.assertEquals(bannerList.get(i).getCreator(),resultListData.getString("creator"));
            Assert.assertEquals(bannerList.get(i).getModifier(),resultListData.getString("modifier"));
            Assert.assertEquals(bannerList.get(i).getDelete_flag(),resultListData.getString("deleteFlag"));
            Assert.assertEquals(bannerList.get(i).getId(),resultListData.getString("id"));
            Assert.assertEquals(bannerList.get(i).getPosition(),resultListData.getString("position"));
            Assert.assertEquals(bannerList.get(i).getTitle(),resultListData.getString("title"));
            Assert.assertEquals(bannerList.get(i).getUrl(),resultListData.getString("url"));
            Assert.assertEquals(bannerList.get(i).getPhoto(),resultListData.getString("photo"));
            Assert.assertEquals(bannerList.get(i).getDisable_flag(),resultListData.getString("disableFlag"));
        }

    }

    private JSONObject getJsonResult() throws IOException {
        HttpGet get = new HttpGet(TestConfig.getBannerTurnUrl);
        System.out.println("get:"+get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        JSONObject resultJson = JSONObject.parseObject(result);
        return resultJson;
    }
}
