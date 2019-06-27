package com.sangame.hjm.cases;

import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.utils.ConfigFile;
import org.testng.annotations.BeforeTest;

public class LoginTest {

    @BeforeTest(groups = "loginTrue",description = "测试准备工作，获取httpClient对象")
    public void beforeTest(){
        TestConfig.updateVersionUrl = ConfigFile.getUrl(InterfaceName.UPDATEVERSION);
        TestConfig.getBannerTurnUrl = ConfigFile.getUrl(InterfaceName.GETBANNERTURN);
        TestConfig.getHomeSubCategoryUrl = ConfigFile.getUrl(InterfaceName.GETHOMESUBCATEGORY);
        TestConfig.searchProjectForConditionUrl = ConfigFile.getUrl(InterfaceName.SEARCHPROJECTFORCONDITION);
        TestConfig.searchCategoryUrl = ConfigFile.getUrl(InterfaceName.SEARCHCATEGORY);
        TestConfig.searchYourLikeUrl = ConfigFile.getUrl(InterfaceName.SEARCHYOURLIKE);
        TestConfig.storeDetailsUrl = ConfigFile.getUrl(InterfaceName.STOREDETAILS);
        TestConfig.onLineMessageUrl = ConfigFile.getUrl(InterfaceName.ONLINEMESSAGE);
        TestConfig.searchInvestmentUrl = ConfigFile.getUrl(InterfaceName.SEARCHINVESTMENT);
        TestConfig.projectCustomUrl = ConfigFile.getUrl(InterfaceName.PROJECTCUSTOM);
        TestConfig.BusinessEnterUrl = ConfigFile.getUrl(InterfaceName.BUSINESSENTER);

    }
}
