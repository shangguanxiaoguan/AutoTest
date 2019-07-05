package com.sangame.hjm.cases;

import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.utils.ConfigFile;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.CookieStore;

public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.updateVersionUrl = ConfigFile.getUrl(InterfaceName.UPDATEVERSION);
        TestConfig.getBannerTurnUrl = ConfigFile.getUrl(InterfaceName.GETBANNERTURN);
        TestConfig.getHomeSubCategoryUrl = ConfigFile.getUrl(InterfaceName.GETHOMESUBCATEGORY);
        TestConfig.keyWordSearchUrl = ConfigFile.getUrl(InterfaceName.KEYWORDSEARCH);
        TestConfig.searchProjectForConditionUrl = ConfigFile.getUrl(InterfaceName.SEARCHPROJECTFORCONDITION);
        TestConfig.searchCategoryUrl = ConfigFile.getUrl(InterfaceName.SEARCHCATEGORY);
        TestConfig.searchYourLikeUrl = ConfigFile.getUrl(InterfaceName.SEARCHYOURLIKE);
        TestConfig.storeDetailsUrl = ConfigFile.getUrl(InterfaceName.STOREDETAILS);
        TestConfig.onLineMessageUrl = ConfigFile.getUrl(InterfaceName.ONLINEMESSAGE);
        TestConfig.searchInvestmentUrl = ConfigFile.getUrl(InterfaceName.SEARCHINVESTMENT);
        TestConfig.projectCustomUrl = ConfigFile.getUrl(InterfaceName.PROJECTCUSTOM);
        TestConfig.BusinessEnterUrl = ConfigFile.getUrl(InterfaceName.BUSINESSENTER);
        TestConfig.searchHomeJoinHeadlineUrl = ConfigFile.getUrl(InterfaceName.GETHOMEJOINHEADLINE);
        TestConfig.searchSubCategoryByCategoryIdUrl = ConfigFile.getUrl(InterfaceName.SEARCHSUBCATEGORYBYCATEGORYID);
        TestConfig.createYunXinIDUrl = ConfigFile.getUrl(InterfaceName.CREATEYUNXINID);
        TestConfig.distributeYunXinIDUrl = ConfigFile.getUrl(InterfaceName.DISTRIBUTEYUNXINID);
        TestConfig.preferenceRecommendUrl = ConfigFile.getUrl(InterfaceName.PREFERENCERECOMMEND);
        TestConfig.userRegisterUrl = ConfigFile.getUrl(InterfaceName.USERREGISTER);

        TestConfig.defaultHttpClient = new DefaultHttpClient();
//        TestConfig.store


    }
}
