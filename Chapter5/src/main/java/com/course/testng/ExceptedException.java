package com.course.testng;

import org.testng.annotations.Test;

/**
 * 异常测试
 */

public class ExceptedException {

    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionFaid(){
        System.out.println("这是一个失败的异常测试(没有跑出期望的异常，所以是失败的)");
    }
    @Test(expectedExceptions = RuntimeException.class)
    public void runTimeExceptionSuccess(){
        System.out.println("这是成功的异常测试");
        throw new RuntimeException();
    }
}
