package com.sangame.hjm.cases;
import com.google.gson.Gson;
import com.sangame.hjm.config.TestConfig;
import com.sangame.hjm.model.*;
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
import java.util.List;

/**
 * 商铺详情接口测试
 */

public class StoreDetailsTest {

    @BeforeTest
    public void beforeTest(){
        TestConfig.storeDetailsUrl = ConfigFile.getUrl(InterfaceName.STOREDETAILS);
        TestConfig.defaultHttpClient = new DefaultHttpClient();
    }

    @Test(description = "商铺详情接口测试")
    public void storeDetails() throws IOException {
        SqlSession sqlSession = DatebaseUtil.getSqlSession();
        StoreDetailsCase storeDetailsCase = sqlSession.selectOne("storeDetailsCase",1);
        System.out.println("storeDetailsCase:" + storeDetailsCase.toString());

        //发送请求，获取接口返回数据
        StoreDetailsResult result = getResponseResult(storeDetailsCase);
        System.out.println("商铺详情接口返回数据：" + result.toString());
        System.out.println("商铺详情接口返回的data数据：" + result.getData().toString());

        //获取期望结果
//        List<StoreDetailsResult> jmProject = sqlSession.selectList("storeDetails",storeDetailsCase); //SQL还没写
        JmProject expectedResult = sqlSession.selectOne("getJmProject",storeDetailsCase);
        System.out.println("获取商铺：" + expectedResult.toString());
        JmProjectExtra jmProjectExtra = sqlSession.selectOne("getJmProjectExtra",storeDetailsCase);
        if (jmProjectExtra != null){
            System.out.println("获取商铺介绍：" + jmProjectExtra.toString());
        }
        List<JmProjectPhoto> jmProjectPhoto = sqlSession.selectList("getJmProjectPhoto",storeDetailsCase);
        if (!jmProjectPhoto.isEmpty()){
            System.out.println("获取商铺照片：" + jmProjectPhoto.toString());
        }
        JmProjectStat jmProjectStat = sqlSession.selectOne("getJmProjectStat",storeDetailsCase);
        if (jmProjectStat != null){
            System.out.println("获取商铺加盟详情：" + jmProjectStat.toString());
        }

        //验证结果
        Assert.assertEquals(result.getCode(),0);

        if (result.getData().isDeleteFlag().equals("false")){
            result.getData().setDeleteFlag("0");
        }else if (result.getData().isDeleteFlag().equals("true")){
            result.getData().setDeleteFlag("1");
        }

//        "categoryName": null,
//         "subCategoryName": null,

        Assert.assertEquals(result.getData().getCreateAt(),DateFormatChange.dateFormatChange(expectedResult.getCreateAt()));
        Assert.assertEquals(result.getData().getUpdateAt(),DateFormatChange.dateFormatChange(expectedResult.getUpdateAt()));
        Assert.assertEquals(result.getData().getCreator(),expectedResult.getCreator());
        Assert.assertEquals(result.getData().getModifier(),expectedResult.getModifier());
        Assert.assertEquals(result.getData().isDeleteFlag(),String.valueOf(expectedResult.getDeleteFlag()));
        Assert.assertEquals(result.getData().getId(),expectedResult.getId());
        Assert.assertEquals(result.getData().getCategoryId(),expectedResult.getCategoryId());
        Assert.assertEquals(result.getData().getSubCategoryId(),expectedResult.getSubCategoryId());
        Assert.assertEquals(result.getData().getCompanyId(),expectedResult.getCompanyId());
        Assert.assertEquals(result.getData().getTitle(),expectedResult.getTitle());
        Assert.assertEquals(result.getData().getKeyword(),expectedResult.getKeyword());
        Assert.assertEquals(result.getData().getPhoto(),expectedResult.getPhoto());
        Assert.assertEquals(result.getData().getRecommendFlag(),expectedResult.getRecommendFlag());
        Assert.assertEquals(result.getData().getBuildDate(), DateFormatChange.stringDateFormatChange(expectedResult.getBuildDate()));
        Assert.assertEquals(result.getData().getOriginAddr(),expectedResult.getOriginAddr());
        Assert.assertEquals(result.getData().getBusinessModel(),expectedResult.getBusinessModel());
        Assert.assertEquals(result.getData().getProduct(),expectedResult.getProduct());
        Assert.assertEquals(result.getData().getCrowd(),expectedResult.getCrowd());
        Assert.assertEquals(result.getData().getArea(),expectedResult.getArea());
        Assert.assertEquals(result.getData().getSupport(),expectedResult.getSupport());
        Assert.assertEquals(result.getData().getInvestMin(),expectedResult.getInvestMin());
        Assert.assertEquals(result.getData().getInvestMax(),expectedResult.getInvestMax());
        Assert.assertEquals(result.getData().getMargin(),expectedResult.getMargin());
        Assert.assertEquals(result.getData().getFacilityCost(),expectedResult.getFacilityCost());
        if (expectedResult.getOtherCost() == null){
            Assert.assertEquals(result.getData().getOtherCost(),expectedResult.getOtherCost());
        }else{
            Assert.assertEquals(result.getData().getOtherCost(),Double.valueOf(expectedResult.getOtherCost()));
        }

        Assert.assertEquals(result.getData().getDescription(),expectedResult.getDescription());
        Assert.assertEquals(result.getData().getCompanyName(),expectedResult.getCompanyName());
        Assert.assertEquals(result.getData().getRegisterTime(),expectedResult.getRegisterTime());
        Assert.assertEquals(result.getData().getState(),expectedResult.getState());
        if (result.getData().getState() == 0){
            Assert.assertEquals(result.getData().getStateName(),"待上架");
        }else if (result.getData().getState() == 1){
            Assert.assertEquals(result.getData().getStateName(),"上架中");
        }else if (result.getData().getState() == 2){
            Assert.assertEquals(result.getData().getStateName(),"已下线");
        }
        //验证商铺介绍数据
        if (result.getData().getProjectExtra() != null && jmProjectExtra !=null){
            if (result.getData().getProjectExtra().isDeleteFlag().equals("false")){
                result.getData().setDeleteFlag("0");
            }else if (result.getData().getProjectExtra().isDeleteFlag().equals("true")){
                result.getData().setDeleteFlag("1");
            }
            Assert.assertEquals(result.getData().getProjectExtra().getCreateAt(),DateFormatChange.dateFormatChange(jmProjectExtra.getCreatedAt()));
            Assert.assertEquals(result.getData().getProjectExtra().getUpdateAt(),DateFormatChange.dateFormatChange(jmProjectExtra.getUpdatedAt()));
            Assert.assertEquals(result.getData().getProjectExtra().getCreator(),jmProjectExtra.getCreator());
            Assert.assertEquals(result.getData().getProjectExtra().getModifier(),jmProjectExtra.getModifier());
            Assert.assertEquals(result.getData().getProjectExtra().isDeleteFlag(),jmProjectExtra.getDeleteFlag());
            Assert.assertEquals(result.getData().getProjectExtra().getId(),jmProjectExtra.getId());
            Assert.assertEquals(result.getData().getProjectExtra().getProjectId(),jmProjectExtra.getProjectId());
            Assert.assertEquals(result.getData().getProjectExtra().getIntroduce(),jmProjectExtra.getIntroduce());
        }


        //验证商铺照片数据
        Assert.assertEquals(result.getData().getProjectPhotos().size(),jmProjectPhoto.size());
        if (!jmProjectPhoto.isEmpty() && !result.getData().getProjectPhotos().isEmpty()){
            for (int i = 0; i <jmProjectPhoto.size();i++){
//                System.out.println("--------------" + result.getData().getProjectPhotos().get(i).isDeleteFlag());
//                if (result.getData().getProjectPhotos().get(i).isDeleteFlag()== false){
//                    result.getData().setDeleteFlag("0");
//                }else if (result.getData().getProjectPhotos().get(i).isDeleteFlag()== true){
//                    result.getData().setDeleteFlag("1");
//                }
                if (jmProjectPhoto.get(i).getDelete_flag().equals("0")){
                    jmProjectPhoto.get(i).setDelete_flag("false");
                }else if(jmProjectPhoto.get(i).getDelete_flag().equals("1")){
                    jmProjectPhoto.get(i).setDelete_flag("true");
                }
                Assert.assertEquals(result.getData().getProjectPhotos().get(i).getCreateAt(),DateFormatChange.dateFormatChange(jmProjectPhoto.get(i).getCreated_at()));
                Assert.assertEquals(result.getData().getProjectPhotos().get(i).getUpdateAt(),DateFormatChange.dateFormatChange(jmProjectPhoto.get(i).getUpdated_at()));
                Assert.assertEquals(result.getData().getProjectPhotos().get(i).getCreator(),jmProjectPhoto.get(i).getCreator());
                Assert.assertEquals(result.getData().getProjectPhotos().get(i).getModifier(),jmProjectPhoto.get(i).getModifier());
                Assert.assertEquals(String.valueOf(result.getData().getProjectPhotos().get(i).isDeleteFlag()),jmProjectPhoto.get(i).getDelete_flag());
                Assert.assertEquals(result.getData().getProjectPhotos().get(i).getId(),jmProjectPhoto.get(i).getId());
                Assert.assertEquals(result.getData().getProjectPhotos().get(i).getProjectId(),jmProjectPhoto.get(i).getProject_id());
                Assert.assertEquals(result.getData().getProjectPhotos().get(i).getPhoto(),jmProjectPhoto.get(i).getPhoto());
            }
        }


        //验证猜你喜欢数据

        //验证商铺加盟详情数据
        if (result.getData().getStat() !=null && jmProjectStat !=null){
            if (result.getData().getStat().isDeleteFlag().equals("false")){
                result.getData().setDeleteFlag("0");
            }else if (result.getData().getStat().isDeleteFlag().equals("true")){
                result.getData().setDeleteFlag("1");
            }
            //Assert.assertEquals(result.getData().getStat().getCreateAt(),DateFormatChange.dateFormatChange(jmProjectStat.getCreated_at()));
            //Assert.assertEquals(result.getData().getStat().getUpdateAt(),DateFormatChange.dateFormatChange(jmProjectStat.getUpdated_at()));
            Assert.assertEquals(result.getData().getStat().getCreator(),jmProjectStat.getCreator());
            Assert.assertEquals(result.getData().getStat().getModifier(),jmProjectStat.getModifier());
            if (jmProjectStat.getDelete_flag().equals("0")){
                jmProjectStat.setDelete_flag("false");
            }else if(jmProjectStat.getDelete_flag().equals("1")){
                jmProjectStat.setDelete_flag("true");
            }
            Assert.assertEquals(String.valueOf(result.getData().getStat().isDeleteFlag()),jmProjectStat.getDelete_flag());
            Assert.assertEquals(result.getData().getStat().getId(),jmProjectStat.getId());
            Assert.assertEquals(result.getData().getStat().getProjectId(),jmProjectStat.getProject_id());
            Assert.assertEquals(result.getData().getStat().getApplyCount(),jmProjectStat.getApply_count());
            if (jmProjectStat.getVisit_count() ==0){
                Assert.assertEquals(result.getData().getStat().getVisitCount(),null);
            }else{
                Assert.assertEquals(result.getData().getStat().getVisitCount(),jmProjectStat.getVisit_count());
            }
            if (jmProjectStat.getJoin_store_count() == 0){
                Assert.assertEquals(result.getData().getStat().getJoinStoreCount(),null);
            }else{
                Assert.assertEquals(result.getData().getStat().getJoinStoreCount(),jmProjectStat.getJoin_store_count());
            }
            if (jmProjectStat.getDirect_store_count() ==0){
                Assert.assertEquals(result.getData().getStat().getDirectStoreCount(),null);
            }else{
                Assert.assertEquals(result.getData().getStat().getDirectStoreCount(),jmProjectStat.getDirect_store_count());
            }

        }

    }

    private StoreDetailsResult getResponseResult(StoreDetailsCase storeDetailsCase) throws IOException {
        HttpGet get = new HttpGet(TestConfig.storeDetailsUrl + "?projectId=" + storeDetailsCase.getProjectId());
        System.out.println("storeDetailsUrl get：" + get);
        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String result = EntityUtils.toString(response.getEntity());
        StoreDetailsResult resultClass = new Gson().fromJson(result,StoreDetailsResult.class);
        return resultClass;
    }
}
