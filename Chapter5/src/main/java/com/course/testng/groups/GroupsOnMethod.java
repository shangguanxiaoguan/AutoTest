package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

/**
 * 组测试中的方法：分组测试
 */

public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端的测试方法11111111");
    }
    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端的测试方法2222222");
    }
    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端的测试方法33333333");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端的测试方法44444444");
    }
    @BeforeGroups("server")
    public void beforeGroupsOnServer(){
        System.out.println("这是服务端组运行之前运行的方法");
    }
    @AfterGroups("server")
    public void afterGroupsOnServer(){
        System.out.println("这是服务端组运行之后运行的方法");
    }
    @BeforeGroups("client")
    public void beforeGroupsOnClient(){
        System.out.println("这是客户端组运行之前运行的方法");
    }
    @AfterGroups("client")
    public void afterGroupsOnClient(){
        System.out.println("这是客户组运行之后运行的方法");
    }

}
