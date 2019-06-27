package com.sangame.hjm.model;

import lombok.Data;

@Data
public class KeyWordSearchCase {
    private String keyword;
    private int pageStart;
    private int pageSize;
}
