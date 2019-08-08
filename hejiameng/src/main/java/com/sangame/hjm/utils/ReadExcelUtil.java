package com.sangame.hjm.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * 使用Excel传递参数
 */


public class ReadExcelUtil {
    //遍历Excel，sheet参数
    public static Object[][] readExData(String filePath,int sheetId) throws IOException {
        File file = new File(filePath);
        FileInputStream fis = new FileInputStream(file);

        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sh = wb.getSheetAt(sheetId);
        int numberrow = sh.getPhysicalNumberOfRows();
        int numbercell = sh.getRow(0).getLastCellNum();
        Object[][] dttData = new Object[numberrow][numbercell];
        for (int i = 0; i  < numberrow; i++){
            if (null == sh.getRow(i) || "".equals(sh.getRow(i))){
                continue;
            }
            for (int j = 0; j < numbercell; j++){
                if (null == sh.getRow(i).getCell(j) || "".equals(sh.getRow(i).getCell(j))){
                    continue;
                }
                HSSFCell cell = sh.getRow(i).getCell(j);
                cell.setCellType(CellType.STRING);
                dttData[i][j] = cell.getStringCellValue();
            }
        }
        return dttData;
    }
}
