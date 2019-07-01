package com.sangame.hjm.model;

import lombok.Data;

@Data
public class KeyWordSearchCase {
//    private int id;
    private String keyword;
    private int pageNum;
    private int pageSize;
    private String expect;
}
