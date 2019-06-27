package com.sangame.hjm.model;

import lombok.Data;

@Data
public class SearchProjectForConditionCase {
//    private int id;
    private String title;
    private String amountCode;
    private String sortCode;
    private String subCategoryId;
    private String pageSize;
    private String pageNum;
    private String expect;
}
