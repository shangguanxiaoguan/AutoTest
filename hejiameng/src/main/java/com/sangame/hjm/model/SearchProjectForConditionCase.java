package com.sangame.hjm.model;

import lombok.Data;

@Data
public class SearchProjectForConditionCase {
//    private int id;
    private String title;
    private int amountCode;
    private int sortCode;
    private int subCategoryId;
    private int categoryId;
    private int pageSize;
    private int pageNum;
    private String expect;
}
