package com.sangame.hjm.config;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.util.*;

public class TestngListener extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult result) {
        super.onTestStart(result);
        System.out.println(result.getName() + "Start");
        ITestContext context = result.getTestContext();
        int passedCount = context.getPassedTests().size();
        int failedCount = context.getFailedTests().size();
        int skipCount = context.getSkippedTests().size();
        int totalCount = passedCount + failedCount + skipCount;
        System.out.println("成功个数：" + passedCount);
        System.out.println("失败个数：" + failedCount);
        System.out.println("跳过个数：" + skipCount);
        System.out.println("当前执行总个数：" + totalCount);

    }

    @Override
    public void onTestSuccess(ITestResult tr) {
        super.onTestSuccess(tr);
        System.out.println(tr.getName() + "Success");
    }

    @Override
    public void onTestFailure(ITestResult tr) {
        super.onTestFailure(tr);
        System.out.println(tr.getName() + "Failure");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        super.onTestSkipped(tr);
        System.out.println(tr.getName() + "Skipped");
    }

    /**
     * 减去失败重试的次数，即使有失败重试，总用例数保持不变
     * @param testContext
     */
    @Override
    public void onFinish(ITestContext testContext) {
        super.onFinish(testContext);
        ArrayList<ITestResult> testsToBeRemoved = new ArrayList<ITestResult>();
        //存储所有通过的测试用例id的集合
        Set<Integer> passedTestIds = new HashSet<Integer>();
        for (ITestResult passedTest : testContext.getPassedTests().getAllResults()){
            System.out.println("PassedTests = " + passedTest.getName());
            passedTestIds.add(getId(passedTest));
        }

        Set<Integer> failedTestIds = new HashSet<Integer>();
        for (ITestResult failedTest : testContext.getFailedTests().getAllResults()){
            System.out.println("FailedTests = " + failedTest.getName());
            //failedTestIds.add(getId(failedTest));
            int failedTestId = getId(failedTest);

            //如果在标记为要删除之前，我们将此测试视为失败的测试
            //如果至少有一个通过的版本，则删除这个失败的测试
            if (failedTestIds.contains(failedTestId) || passedTestIds.contains(failedTestId)){
                testsToBeRemoved.add(failedTest);
            }else{
                failedTestIds.add(failedTestId);
            }
        }

        for (Iterator<ITestResult> iterator = testContext.getFailedTests().getAllResults().iterator();iterator.hasNext();){
            ITestResult testResult = iterator.next();
            if (testsToBeRemoved.contains(testResult)){
                System.out.println("删除重复失败的测试用例：" + testResult.getName());
                iterator.remove();
            }
        }

    }




    private Integer getId(ITestResult result) {
        int id = result.getTestClass().getName().hashCode();
        id = id + result.getMethod().getMethodName().hashCode();
        id = id + (result.getParameters()!= null ? Arrays.hashCode(result.getParameters()) :0);
        return id;
    }


}
