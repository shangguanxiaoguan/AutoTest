package com.sangame.hjm.model;

import lombok.Data;

@Data
public class SearchSubCategoryByCategoryIdCase {
    private int id;
    private String categoryId;
    private String expected;
}
