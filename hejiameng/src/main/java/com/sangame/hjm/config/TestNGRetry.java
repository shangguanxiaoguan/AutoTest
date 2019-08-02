package com.sangame.hjm.config;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * TestNG 失败重试
 * 一个用例执行失败以后再执行几次，避免因为环境不稳定等外部因素引发的失败
 */


public class TestNGRetry implements IRetryAnalyzer {
    private int retryCount = 1;//设置当前的重跑次数
    private static int maxRetryCount; //设置最大重跑次数，定义为常量

    static {
        maxRetryCount = 3;
        System.out.println("最大运行次数：" + maxRetryCount);
    }

    /**
     *
     * @param iTestResult
     * @return    return true 表示没达到最大运行次数，如果执行失败，还会继续重试
     *             return false 表示达到最大运行次数
     */
    @Override
    public boolean retry(ITestResult iTestResult) {
        System.out.println("执行结果：" + iTestResult.isSuccess());
        if (retryCount < maxRetryCount){
            System.out.println("当前重跑次数：" + retryCount + "；当前正在重跑的用例名称：" + iTestResult.getName());
            retryCount ++;//重跑之后，次数加1
            return true;
        }
        /**
         * 同一个测试方法，如果第一条数据重试过了retryCount达到最大，第二条数据就不会再重试，
         * 需要把retryCount重新置为1
         */
        retryCount = 1;
        return false;
    }
//    public void reSetCount(){
//        retryCount = 1;
//    }
}
