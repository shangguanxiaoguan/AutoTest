package com.course.testng.groups;

import org.testng.annotations.Test;

@Test(groups = "teacher")
public class GroupsOnClass3 {
    public void teacher1(){
        System.out.println("GroupsOnClass3的teacher111111111执行");
    }
    public void teacher2(){
        System.out.println("GroupsOnClass3的teacher22222222222执行");
    }
}
