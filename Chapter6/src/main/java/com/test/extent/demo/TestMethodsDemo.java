package com.test.extent.demo;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * TestNG断言及日志方法
 */

public class TestMethodsDemo {

    @Test
    public void test1(){
        Assert.assertEquals(1,2);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test3(){
        Assert.assertEquals("aaaa","adbdv");
    }
    @Test
    public void logDemo(){
        Reporter.log("这是手动写的日志");
        throw new RuntimeException("这是程序抛出的日志");
    }




}
