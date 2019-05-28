package com.course.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * 参数化测试：DataProvider参数化
 */

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void dataProviderTest(String name,int age){
        System.out.println("name = " + name + "; age = "+ age);
    }
    @DataProvider(name = "data")
    public Object[][] dateProvider(){
        Object[][] o = new Object[][]{
                {"zhangsan",10},
                {"lisi",15},
                {"wangwu",20}
        };
        return o;
    }

    /**
     * 通过方法名传入参数
     * @param name
     * @param age
     */

    @Test(dataProvider = "methodData")
    public void test1(String name,int age){
        System.out.println("test111的方法： name = " + name + "; age = "+ age);
    }
    @Test(dataProvider = "methodData")
    public void test2(String name,int age){
        System.out.println("test2的方法： name = " + name + "; age = "+ age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if (method.getName().equals("test1")){
            result = new Object[][]{
                    {"张三",20},
                    {"李四",25},
                    {"王五",30}
            };
        }else if (method.getName().equals("test2")){
            result = new Object[][]{
                    {"赵六",50},
                    {"周七",60}
            };
        }
        return result;
    }
}
