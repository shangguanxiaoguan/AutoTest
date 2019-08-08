package com.sangame.hjm.base;


import com.sangame.hjm.utils.PropertiesUtil;
import org.testng.annotations.BeforeClass;

import java.util.Locale;
import java.util.ResourceBundle;

/**
  * 该类可以当成所有测试类的模板基类，其他需要测试的类继承该类；可以读取配置文件
  * session,token等需要全局使用的均需要在此类中进行定义；若测试需要登录可在本类进行登录
  * @author ghj
  * @date 2018年9月25日
  * @version V1.0.1
  */
public abstract class BaseApi {
//    public static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);
    protected String hostManager;
    protected String testCaseExcel;
    protected static String sessionKey;

    @BeforeClass
    public void setUp() {
//        hostManager = PropertiesUtils.getConfigValue("HOSTMANAGER");
        testCaseExcel = PropertiesUtil.getConfigValue("testcasedata");
    }
}