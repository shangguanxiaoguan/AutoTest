package com.course.testng;

import org.testng.annotations.Test;

/**
 * 超时测试
 */

public class TimeoutTest {
    @Test(timeOut = 3000)//单位为毫秒。期望在3000ms内作出响应
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)
    public void testFailed() throws InterruptedException {
        Thread.sleep(3000);
    }
}
