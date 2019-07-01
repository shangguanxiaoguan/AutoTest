package com.sangame.hjm.model;

import lombok.Data;

@Data
public class JmSubCategory {
    private int id;
    private String created_at;
    private String updated_at;
    private String creator;
    private String modifier;
    private int category_id;
    private String title;
    private String spell;
    private String icon;
    private Integer hot_flag;
    private Integer recommend_flag;
    private int index_flag;
    private Integer delete_flag;
}
