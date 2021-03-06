package com.sangame.hjm.utils;

import com.sangame.hjm.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;

public class ConfigFile {
    public static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");
        String uri = "";
        String testUrl;
        if (name == InterfaceName.UPDATEVERSION){
            uri = bundle.getString("updateVersion.uri");
        }
        if (name == InterfaceName.GETBANNERTURN){
            uri = bundle.getString("bannerTurn.uri");
        }
        if (name == InterfaceName.GETHOMESUBCATEGORY){
            uri = bundle.getString("homeSubCategory.uri");
        }
        if (name == InterfaceName.KEYWORDSEARCH){
            uri = bundle.getString("keyWordSearch.uri");
        }
        if (name == InterfaceName.SEARCHPROJECTFORCONDITION){
            uri = bundle.getString("searchProjectForCondition.uri");
        }
        if(name == InterfaceName.SEARCHCATEGORY){
            uri = bundle.getString("searchCategory.uri");
        }
        if (name == InterfaceName.SEARCHYOURLIKE){
            uri = bundle.getString("searchYourLike.uri");
        }
        if (name == InterfaceName.STOREDETAILS){
            uri = bundle.getString("storeDetails.uri");
        }
        if (name == InterfaceName.ONLINEMESSAGE){
            uri = bundle.getString("onLineMessage.uri");
        }
        if(name == InterfaceName.SEARCHINVESTMENT){
            uri = bundle.getString("searchInvestment.uri");
        }
        if (name == InterfaceName.PROJECTCUSTOM){
            uri = bundle.getString("projectCustom.uri");
        }
        if (name == InterfaceName.BUSINESSENTER){
            uri = bundle.getString("BusinessEnter.uri");
        }
        if (name == InterfaceName.GETHOMEJOINHEADLINE){
            uri = bundle.getString("getHomeJoinHeadline.uri");
        }
        if (name == InterfaceName.SEARCHSUBCATEGORYBYCATEGORYID){
            uri = bundle.getString("searchSubCategoryByCategoryId.uri");
        }
        if (name == InterfaceName.CREATEYUNXINID){
            uri = bundle.getString("createYunXinID.uri");
        }
        if (name == InterfaceName.DISTRIBUTEYUNXINID){
            uri = bundle.getString("distributeYunXinID.uri");
        }
        if (name == InterfaceName.PREFERENCERECOMMEND){
            uri = bundle.getString("preferenceRecommend.uri");
        }
        if (name == InterfaceName.BUSINESSHOTSEARCH){
            uri = bundle.getString("businessHotSearch.uri");
        }
        if (name == InterfaceName.USERREGISTER){
            uri = bundle.getString("userRegister.uri");
        }
        if (name == InterfaceName.SENDMOBILE){
            uri = bundle.getString("sendMobile.uri");
        }
        if (name == InterfaceName.LOGINORREGISTER){
            uri = bundle.getString("loginOrRegister.uri");
        }
        if (name == InterfaceName.SEARCHALLTRADE)  {
            uri = bundle.getString("searchAllTrade.uri");
        }
        testUrl = address + uri;
        return testUrl;
    }
}
