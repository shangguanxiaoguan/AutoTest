package com.sangame.hjm.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


/**
 * 使用Excel传递参数
 *
 * Java Excel读取数据 ：https://www.jianshu.com/p/84752aa5a1b7
 */


public class ReadExcelUtil {

//    public static void main(String[] args){
//        List<Map<String,String>> list = getData("F:\\\\testCaseData.xlsx");
//        for (Map<String,String> map : list){
//            System.out.println("map:" + map);
//        }
//    }

    public static List<Map<String,String>> getData(String filePath){
        Workbook wb = null;
        Sheet sheet = null;
        Row row1 = null;
        Row row = null;
        List<Map<String, String>> list = null;
        String cellData = null;
//        String columns[] = { "cngoldId", "commentId", "content"};
        wb = readExcel(filePath);
        if (wb != null){
            // 用来存放表中数据
            list = new ArrayList<Map<String, String>>();
            // 获取第一个sheet
            sheet = wb.getSheetAt(0);
            // 获取最大行数
            int rownum = sheet.getPhysicalNumberOfRows();
            // 获取第一行
//            row = sheet.getRow(0);
            row1 = sheet.getRow(0);
            //System.out.println("row:" + row1);
            // 获取最大列数
//            int colnum = row.getPhysicalNumberOfCells();
            int colnum = row1.getPhysicalNumberOfCells();
            for (int i = 1; i < rownum; i++) {
                Map<String, String> map = new LinkedHashMap<String, String>();
                row = sheet.getRow(i);
                if (row != null) {
                    for (int j = 0; j < colnum; j++) {
                        cellData = (String) getCellFormatValue(row.getCell(j));
//                        map.put(columns[j], cellData);
                        map.put(String.valueOf(row1.getCell(j)), cellData);
                    }
                } else {
                    break;
                }
                list.add(map);
            }
        }
        return list;
        }

    private static Workbook readExcel(String filePath) {
        Workbook wb = null;
        if (filePath == null) {
            return null;
        }
        String extString = filePath.substring(filePath.lastIndexOf("."));
        InputStream is = null;
        try {
            is = new FileInputStream(filePath);
            if (".xls".equals(extString)) {
                wb = new HSSFWorkbook(is);
                return wb;
            } else if (".xlsx".equals(extString)) {
                wb = new XSSFWorkbook(is);
                return wb;
            } else {
                wb = null;
                return wb;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    private static Object getCellFormatValue(Cell cell) {
        Object cellValue = null;
        if (cell != null) {
            // 判断cell类型
            switch (cell.getCellType()) {
                case Cell.CELL_TYPE_NUMERIC: {
                    cellValue = String.valueOf(cell.getNumericCellValue());
                    break;
                }
                case Cell.CELL_TYPE_FORMULA: {
                    // 判断cell是否为日期格式
                    if (DateUtil.isCellDateFormatted(cell)) {
                        // 转换为日期格式YYYY-mm-dd
                        cellValue = cell.getDateCellValue();
                    } else {
                        // 数字
                        cellValue = String.valueOf(cell.getNumericCellValue());
                    }
                    break;
                }
                case Cell.CELL_TYPE_STRING: {
                    cellValue = cell.getRichStringCellValue().getString();
                    break;
                }
                default:
                    cellValue = "";
            }
        } else {
            cellValue = "";
        }
        return cellValue;
    }


    //遍历Excel，sheet参数
//    public static Object[][] readExData(String filePath,int sheetId) throws IOException {
//        File file = new File(filePath);
//        FileInputStream fis = new FileInputStream(file);
////        HSSFWorkbook wb = new HSSFWorkbook(fis);
//        XSSFWorkbook wb = new XSSFWorkbook(fis);
//        XSSFSheet sh = wb.getSheetAt(sheetId);
//        int numberrow = sh.getPhysicalNumberOfRows();
//        //int numbercell = sh.getRow(1).getLastCellNum();
//        int numbercell = sh.getRow(1).getLastCellNum();
//        Object[][] dttData = new Object[numberrow][numbercell];
//        for (int i = 0; i  < numberrow; i++){
//            if (null == sh.getRow(i) || "".equals(sh.getRow(i))){
//                continue;
//            }
//            for (int j = 0; j < numbercell; j++){
//                if (null == sh.getRow(i).getCell(j) || "".equals(sh.getRow(i).getCell(j))){
//                    continue;
//                }
//                XSSFCell cell = sh.getRow(i).getCell(j);
//                cell.setCellType(CellType.STRING);
//                dttData[i][j] = cell.getStringCellValue();
//            }
//        }
//        return dttData;
//    }
}
