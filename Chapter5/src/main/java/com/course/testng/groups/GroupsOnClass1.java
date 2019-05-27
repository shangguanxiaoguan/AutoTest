package com.course.testng.groups;

import org.testng.annotations.Test;

/**
 * 组测试中的：类分组测试
 */


@Test(groups = "student")
public class GroupsOnClass1 {
    public void student1(){
        System.out.println("GroupsOnClass1的student1执行");
    }
    public void student2(){
        System.out.println("GroupsOnClass1的student2执行");
    }
    public void student3(){
        System.out.println("GroupsOnClass1的student3执行");
    }
}
