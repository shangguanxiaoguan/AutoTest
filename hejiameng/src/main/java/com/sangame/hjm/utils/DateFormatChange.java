package com.sangame.hjm.utils;

public class DateFormatChange {
    /**
     * 把时间格式为 2019-06-24 15:05:52.0 改成 2019-06-25 00:00:00
     * @param stringDate
     * @return
     */
    public static String stringDateFormatChange(String stringDate){
        //用空格分割字符串
        String[] createdArr = stringDate.split(" ");
        //取出空格前面的字符串
        String date = createdArr[0];
        //取完字符串后再拼接
        date = date + " 00:00:00";
        return date;
    }

    /**
     * 把时间格式为 2019-06-24 15:05:52.0 改成2019-06-24 15:05:52
     * @param stringDate
     * @return
     */
    public static String DateFormatChange(String stringDate){
        String date = stringDate.replace(".0","");
        return date;
    }
}
