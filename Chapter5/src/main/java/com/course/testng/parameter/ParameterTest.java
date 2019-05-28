package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * 参数化测试 ---XML文件参数化
 */

public class ParameterTest {
    @Test
    @Parameters({"name","age"})
    public void paramTest1(String name,int age){
        System.out.println("name = " + name + "; age = " + age);
//        System.out.println("name = lisi"+"; age = 12");
    }
}
