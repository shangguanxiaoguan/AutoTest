package com.course.testng.multithread;

import org.testng.annotations.Test;

/**
 * 多线程测试===>注解方式实现
 */

public class MultiThreadOnAnnotation {

    @Test(invocationCount = 10)
    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id：%s%n",Thread.currentThread().getId());
    }

    @Test(invocationCount = 10,threadPoolSize = 3)
    public void test2(){
        System.out.println(1);
        System.out.printf("Thread Id：%s%n",Thread.currentThread().getId());
    }
}
