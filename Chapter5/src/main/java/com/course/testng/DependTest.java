package com.course.testng;

import org.testng.annotations.Test;

/**
 * 依赖测试：只有test1成功执行了，test2才能顺利执行。
 * 例如：只有先登录才能进行交易
 *
 */

public class DependTest {
    @Test
    public void test1(){
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2(){
        System.out.println("test2 run");
    }
}
