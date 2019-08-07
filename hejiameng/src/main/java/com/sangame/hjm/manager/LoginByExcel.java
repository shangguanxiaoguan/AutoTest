package com.sangame.hjm.manager;

import com.sangame.hjm.utils.ReadExcel;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class LoginByExcel {
    @DataProvider(name = "post")
    public Object[][] post() throws IOException {
        //Excel表格中的sheet页来填写数字参数，第一页下标为0
       // return ReadExcel.readExData(testCaseExcel,1);
        return null;
}

}
