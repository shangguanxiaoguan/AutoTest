package com.sangame.hjm.cases;

import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.DistributeYunXinIDCase;
import com.sangame.hjm.model.DistributeYunXinIDResult;
import com.sangame.hjm.model.InterfaceName;
import com.sangame.hjm.model.JmYunXin;
import com.sangame.hjm.utils.ConfigFile;
import com.sangame.hjm.utils.DateFormatChange;
import com.sangame.hjm.utils.DatebaseUtil;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


/**
 * 分配云信客服接口测试
 */


public class DistributeYunXinIDTest {
    @BeforeTest
    public void beforeTest(){
        TestConfig.distributeYunXinIDUrl = ConfigFile.getUrl(InterfaceName.DISTRIBUTEYUNXINID);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test
    public void distributeYunXinID() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        DistributeYunXinIDCase distributeYunXinIDCase = sqlSession.selectOne("distributeYunXinIDCase",3);
        System.out.println("测试用例数据：" + distributeYunXinIDCase.toString());
        //发送请求，获取接口返回数据
        DistributeYunXinIDResult result = getResponseResult(distributeYunXinIDCase);
        System.out.println("分配云信客服接口返回的结果：" + result.toString());

        //获取数据库数据
//        SqlSession expectedSession = DatebaseUtil.getSqlSession();
//        JmYunXin expectedResult = expectedSession.selectOne("getDistributeYunXinID",distributeYunXinIDCase);
//        System.out.println("查询数据库结果：" + expectedResult.toString());
        //验证结果
        Assert.assertEquals(result.getCode(),0);
//        Assert.assertEquals(result.getData().getCreateAt(), DateFormatChange.dateFormatChange(expectedResult.getCreated_at()));
//        Assert.assertEquals(result.getData().getUpdateAt(), DateFormatChange.dateFormatChange(expectedResult.getUpdated_at()));
//        Assert.assertEquals(result.getData().getCreator(),expectedResult.getCreator());
//        Assert.assertEquals(result.getData().getModifier(),expectedResult.getModifier());
//        if (expectedResult.getDelete_flag() == 0){
//            Assert.assertEquals(result.getData().isDeleteFlag(),false);
//        }else if (expectedResult.getDelete_flag() == 1){
//            Assert.assertEquals(result.getData().isDeleteFlag(),true);
//        }
//        Assert.assertEquals(result.getData().getId(),expectedResult.getId());
//        Assert.assertEquals(result.getData().getUserId(),expectedResult.getUser_id());
//        Assert.assertEquals(result.getData().getYxAccid(),expectedResult.getYx_accid());
//        Assert.assertEquals(result.getData().getYxName(),expectedResult.getYx_name());
//        Assert.assertEquals(result.getData().getYxToken(),expectedResult.getYx_token());
//        Assert.assertEquals(result.getData().getCrmAgent(),expectedResult.getCrm_agent());
////        Assert.assertEquals(result.getData().getUserImg(),expectedResult.get());
//        Assert.assertEquals(result.getData().getAccessApp(),expectedResult.getAccess_app());


    }

    //http://122.224.240.156:20003/yx/customerService?accId=app_1
    private DistributeYunXinIDResult getResponseResult(DistributeYunXinIDCase distributeYunXinIDCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.distributeYunXinIDUrl + "?accId=" + distributeYunXinIDCase.getAccid());
        System.out.println("分配云信客服用户URL get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        DistributeYunXinIDResult resultClass= new Gson().fromJson(result,DistributeYunXinIDResult.class);
        return resultClass;
    }

}
