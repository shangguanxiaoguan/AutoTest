package com.course.testng;

import org.testng.annotations.*;

/**
 *  基本注解。====>重点关注他们之间的执行顺序
 */

public class BasicAnnotation {

    @Test   //最基本的注解，把方法标记为测试的一部分。
    public void testCase1(){
        System.out.println("Test这是测试用例1");
        System.out.printf("Thread Id：%s%n",Thread.currentThread().getId());
    }

    @Test
    public void testCase2(){
        System.out.println("Test这是测试用例2");
        System.out.printf("Thread Id：%s%n",Thread.currentThread().getId());
    }

    //在每一个测试用例前后都会执行一次
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BeforeMethod这是在测试方法之前运行的");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod这是测试方法之后运行的");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass这是在类之前运行的");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass这是在类之后运行的");
    }

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite这是测试套件");
    }

    @AfterSuite
    public void AfterSuite(){
        System.out.println("AfterSuite这是测试套件");
    }
}
