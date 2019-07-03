package com.sangame.hjm.utils;

public class PageInfoUtil {

//    private Integer pageSize;
//    private Integer pageNum;
//    private Integer pageStart;

    public static Integer pageTransformation(Integer pageSize,Integer pageNum){
        if (pageSize == null){
            pageSize = 10;
        }
        if (pageNum == null || pageNum <=0){
            pageNum = 0;
        }else{
            pageNum = (pageNum - 1) * pageSize;
        }
        return pageNum;
    }

}
